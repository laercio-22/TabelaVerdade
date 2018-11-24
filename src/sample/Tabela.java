package sample;

	import java.awt.Dimension;
	import java.awt.FlowLayout;
	import javax.swing.JFrame;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

	public class Tabela extends JFrame {

		private JTable table;

		public Tabela(String[][] tabela, String termo) {
			String[] header = termo.split(" ");
			setLayout(new FlowLayout());
			setSize(new Dimension(600, 400));
			setLocationRelativeTo(null);
			setTitle("Tabela Verdade");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			table = new JTable(tabela, header);
			table.setPreferredScrollableViewportSize(new Dimension(500,400));
			table.setFillsViewportHeight(true);
			DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
			centralizado.setHorizontalAlignment(SwingConstants.CENTER);
			for(int i = 0; i < table.getColumnCount(); i++)
				table.getColumnModel().getColumn(i).setCellRenderer(centralizado);
			JScrollPane scrollPane=new JScrollPane(table);
 
			add(scrollPane);
		}
}
