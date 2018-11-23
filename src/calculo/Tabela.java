package calculo;

	import java.awt.Dimension;
	import java.awt.FlowLayout;
	import javax.swing.JFrame;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;

	public class Tabela extends JFrame {

		private JTable table;

		public Tabela(String[][] tabela, String termo) {
			String[] header = termo.split(" ");
			setLayout(new FlowLayout());
			setSize(new Dimension(800, 400));
			setLocationRelativeTo(null);
			setTitle("Tabela Verdade");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			table = new JTable(tabela, header);
			table.setPreferredScrollableViewportSize(new Dimension(800,400));
			table.setFillsViewportHeight(true);

			JScrollPane scrollPane=new JScrollPane(table);
 
			add(scrollPane);
		}
}
