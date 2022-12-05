package businessLogics;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javaBeans.Invoice;

public class InvoiceRepository {
	private DriverManagerDataSource ds = CSDL2.getDataSource();
	public int add(Invoice obj) {
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.update("CALL AddInvoice(?, ?, ?, ?, ?)", obj.getId(), obj.getMemberId(), obj.getEmail(),
				obj.getTel(), obj.getAddress());
	}

}
