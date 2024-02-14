package hugo.almoxarifado.almoxaridado;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hugo.almoxarifado.Modulos.Almoxarifado;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ServiceAlmoxarifado {

    @Autowired
    private AlmoxarifadoRepository repository;

    public List<Almoxarifado> findAll() {
        return repository.findAll();
    }

    public Almoxarifado insert(Almoxarifado almoxarifado) {
        if (findByNome(almoxarifado)) {
            throw new IllegalArgumentException("Almoxarifado já existe");
        }
        return repository.save(almoxarifado);
    }

    private boolean findByNome(Almoxarifado almoxarifado) {
        Optional<Almoxarifado> finfByNome = repository.findByNome(almoxarifado.getNome());
        return finfByNome.isPresent();
    }

    public void gerarRelatorioAlmoxarifado(HttpServletResponse response) throws Exception {

        List<Almoxarifado> almoxarifados = repository.findAll();

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(almoxarifados);

        InputStream inputStream = this.getClass().getResourceAsStream("/relatorios/almoxarifado.jasper");

        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

        Map<String, Object> parameters = new HashMap<>();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=relatorio_almoxarifado.pdf");
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }

}
