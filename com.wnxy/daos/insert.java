package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tools.ConnectionManager;

public class insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String goods_code[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","48","50","51","53","54","55","56","57","58","59","60","61","62","63","64","67","68","69","72","74","75","76","77","78","79","80","81","82","83","84","85","86","89","90","91","92","96","98","99","101","102","103","104","105","106","107","110","111","112","113","114","115","117","119","120","121","122","126","127","131","133","134","136","141","142","143","145","150","154","157","161","163","164","201","202","203","222","223","235","236","238","240","245","246","254","266","267","268","350","412","420","421","427","429","432","497","498","516","517","518","523","555"};
		String goods_name[]={"�ڰ�֮Ů ����"," ��սʿ ������"," ������� �����"," ���ƴ�ʦ ��˹��"," �°��ܹ� ����"," ��ηս�� �����"," �������� ��ܽ��"," �ɺ��ո��� �������׶�"," ĩ��ʹ�� �ѵ����"," ������ʹ ����"," �޼���ʥ ��"," ţͷ���� ����˹��"," ���ķ�ʦ ����"," ����ս�� ����"," ս��Ů�� ϣά��"," ����֮�� ������"," Ѹ�ݳ�� ��Ī"," �������� ��˿����"," �氲ŭ�� �����"," ѩԭ˫�� ŬŬ��������"," �ͽ����� ����С��"," �������� ��ϣ"," ����֮�� ̩���׶�"," ������ʦ �ֿ�˹"," ������ʹ Ī����"," ʱ���ػ��� ����"," ������ʿ ������"," ʹ��֮ӵ ��ܽ��"," ����֮Դ ͼ��"," �����̳��� ������˹"," ��տ־� �Ƽ�˹"," ��֮ľ���� ��ľľ"," �������� ��Ī˹"," ������� ����ά��"," ��ħС�� ����"," �氲���� �ɶ�ҽ��"," ��ɪ��Ů ���"," ������� ������"," �������� �������"," �籩֮ŭ ����"," ����֮�� ���ʿ�"," Ӣ��Ͷ���� ����"," ������ ������"," ������֮�� �����"," а��С��ʦ ά��"," ��ħ֮�� ���ʵ¶�"," ŵ����˹ͳ�� ˹ά��"," Ƥ��Ů�� ������"," ���������� �����"," ���Ҿ��� ī����"," ����֮�� ��������"," �������� ħ��"," Ť������ ï��"," ��Į���� �׿˶�"," �������ǻ��� ��������"," ֩��Ů�� ����˿"," ����ħ�� ������"," �����ʥ �����"," ������� ������"," äɮ ����"," ��ҹ���� ޱ��"," ��е���� ����"," ħ��֮ӵ ���������"," ˮ���ȷ� ˹����"," ������ ��Ĭ����"," ɳĮ���� ��ɪ˹"," ��ҰŮ���� �ε���"," �������� �ڵ϶�"," ʥ��֮�� ����"," ��Ͱ ������˹"," ����֮ǹ ��ɭ"," ̽�ռ� �������"," ����ڤ�� Ī�¿���"," ������ Լ���"," ��Ⱥ֮�� ������"," ��֮�� ����"," ��������֮�� ����"," ���Ů�� ��ŷ��"," �����֪ �������"," ����֮Ӱ ̩¡"," ����֮�� ����"," ��Ԩ�޿� �˸�Ī"," ĺ��֮�� ��"," ���Ů�� ����˿"," Զ������ ����˹"," ��Ѫ�伧 ϣ����"," ��β���� ����"," �����ͽ ���׸�˹"," ��ϫ���� ����"," �������� ��������"," ��֮׷���� �׶��Ӷ�"," �ͽ�֮�� Τ³˹"," �̩̹ ŵ����˹"," ��е���� ά����"," ����֮ŭ ɪׯ��"," ��˫���� �ư���"," ���ƹ�� ����˹"," ����Ů�� ��"," ��ҫ���̹� ������"," ս��֮Ӱ �տ���ķ"," ����Ӷ��� ���ȿ�"," ŵ����˹֮�� ������˹"," δ���ػ��� ��˹"," ��˪Ů�� ��ɣ׿"," ���Ů�� �찲��"," ��������֮�� ����"," ����Ԫ�� ������"," �������� ��������������"," Ӱ��֮�� ����"," ĺ������ ����"," ����֮�� ���"," ���֮Ů ��ɯ"," ��ʧ֮�� �ɶ�"," ����ħ�� ����"," ���罣�� ����"," ���֮�� ά����"," ��ȸ ������"," ���Ӱ ���۶�"," ���׶�׿��֮�� ��¡"," Ϸ��ʦ ��"," ����˫�� ǧ��"," �������� ���˿"," ����֮�� ��ķ"," �ӻ�ʥǹ ����"," ʥǹ���� ¬����"," Ӱ��֮�� ��"," ��ŭ��ʿ ����"," ʱ��̿� ����"," Ԫ��Ů�� ������"," Ƥ��ִ���� ε"," ���ὣħ ���п�˹"," �����޼� ����"," ɳĮ�ʵ� ���ȶ�"," ħ��è�� ����"," ���������� ��ʯ"," ���޼�˾ ������"," ��նݵ��� �׿���"," ���� ����"," ����֮ì ����˿��"," �ǽ����� �͵�"," ���� ��"," ���� ϼ"," ɽ��֮�� �¶�"," ������ ����˹"," ��ͨ�� ��ޢ"," ����֮�� �����˹"," Ѫ�۹�Ӱ �ɿ�"};
		
		String goods_img[]={"upload\\LOLPHOTO1002.jpg","upload\\LOLPHOTO1016.jpg","upload\\LOLPHOTO1032.jpg","upload\\LOLPHOTO1048.jpg","upload\\LOLPHOTO1067.jpg","upload\\LOLPHOTO107.jpg","upload\\LOLPHOTO1084.jpg","upload\\LOLPHOTO1102.jpg","upload\\LOLPHOTO1119.jpg","upload\\LOLPHOTO1137.jpg","upload\\LOLPHOTO1154.jpg","upload\\LOLPHOTO1170.jpg","upload\\LOLPHOTO1186.jpg","upload\\LOLPHOTO1202.jpg","upload\\LOLPHOTO1219.jpg","upload\\LOLPHOTO1237.jpg","upload\\LOLPHOTO1253.jpg","upload\\LOLPHOTO126.jpg","upload\\LOLPHOTO1270.jpg","upload\\LOLPHOTO1286.jpg","upload\\LOLPHOTO13.jpg","upload\\LOLPHOTO1304.jpg","upload\\LOLPHOTO1321.jpg","upload\\LOLPHOTO1339.jpg","upload\\LOLPHOTO1355.jpg","upload\\LOLPHOTO1371.jpg","upload\\LOLPHOTO1388.jpg","upload\\LOLPHOTO1403.jpg","upload\\LOLPHOTO1420.jpg","upload\\LOLPHOTO143.jpg","upload\\LOLPHOTO1438.jpg","upload\\LOLPHOTO1456.jpg","upload\\LOLPHOTO1473.jpg","upload\\LOLPHOTO1492.jpg","upload\\LOLPHOTO1509.jpg","upload\\LOLPHOTO1528.jpg","upload\\LOLPHOTO1548.jpg","upload\\LOLPHOTO1566.jpg","upload\\LOLPHOTO1585.jpg","upload\\LOLPHOTO159.jpg","upload\\LOLPHOTO1603.jpg","upload\\LOLPHOTO1621.jpg","upload\\LOLPHOTO1639.jpg","upload\\LOLPHOTO1657.jpg","upload\\LOLPHOTO1674.jpg","upload\\LOLPHOTO1693.jpg","upload\\LOLPHOTO1712.jpg","upload\\LOLPHOTO1731.jpg","upload\\LOLPHOTO174.jpg","upload\\LOLPHOTO1752.jpg","upload\\LOLPHOTO1770.jpg","upload\\LOLPHOTO1788.jpg","upload\\LOLPHOTO1806.jpg","upload\\LOLPHOTO1825.jpg","upload\\LOLPHOTO1843.jpg","upload\\LOLPHOTO1865.jpg","upload\\LOLPHOTO1882.jpg","upload\\LOLPHOTO1899.jpg","upload\\LOLPHOTO1916.jpg","upload\\LOLPHOTO192.jpg","upload\\LOLPHOTO1933.jpg","upload\\LOLPHOTO1950.jpg","upload\\LOLPHOTO1967.jpg","upload\\LOLPHOTO1984.jpg","upload\\LOLPHOTO2002.jpg","upload\\LOLPHOTO2018.jpg","upload\\LOLPHOTO2035.jpg","upload\\LOLPHOTO2055.jpg","upload\\LOLPHOTO2070.jpg","upload\\LOLPHOTO208.jpg","upload\\LOLPHOTO2087.jpg","upload\\LOLPHOTO2105.jpg","upload\\LOLPHOTO2122.jpg","upload\\LOLPHOTO2139.jpg","upload\\LOLPHOTO2157.jpg","upload\\LOLPHOTO2173.jpg","upload\\LOLPHOTO2190.jpg","upload\\LOLPHOTO2207.jpg","upload\\LOLPHOTO2225.jpg","upload\\LOLPHOTO224.jpg","upload\\LOLPHOTO2242.jpg","upload\\LOLPHOTO2261.jpg","upload\\LOLPHOTO2278.jpg","upload\\LOLPHOTO2296.jpg","upload\\LOLPHOTO2313.jpg","upload\\LOLPHOTO2331.jpg","upload\\LOLPHOTO2349.jpg","upload\\LOLPHOTO2368.jpg","upload\\LOLPHOTO2383.jpg","upload\\LOLPHOTO2402.jpg","upload\\LOLPHOTO241.jpg","upload\\LOLPHOTO2419.jpg","upload\\LOLPHOTO2433.jpg","upload\\LOLPHOTO2447.jpg","upload\\LOLPHOTO2464.jpg","upload\\LOLPHOTO2481.jpg","upload\\LOLPHOTO2498.jpg","upload\\LOLPHOTO2517.jpg","upload\\LOLPHOTO2534.jpg","upload\\LOLPHOTO258.jpg","upload\\LOLPHOTO274.jpg","upload\\LOLPHOTO28.jpg","upload\\LOLPHOTO292.jpg","upload\\LOLPHOTO309.jpg","upload\\LOLPHOTO329.jpg","upload\\LOLPHOTO347.jpg","upload\\LOLPHOTO363.jpg","upload\\LOLPHOTO381.jpg","upload\\LOLPHOTO398.jpg","upload\\LOLPHOTO415.jpg","upload\\LOLPHOTO432.jpg","upload\\LOLPHOTO44.jpg","upload\\LOLPHOTO449.jpg","upload\\LOLPHOTO466.jpg","upload\\LOLPHOTO482.jpg","upload\\LOLPHOTO501.jpg","upload\\LOLPHOTO518.jpg","upload\\LOLPHOTO536.jpg","upload\\LOLPHOTO553.jpg","upload\\LOLPHOTO571.jpg","upload\\LOLPHOTO587.jpg","upload\\LOLPHOTO60.jpg","upload\\LOLPHOTO605.jpg","upload\\LOLPHOTO621.jpg","upload\\LOLPHOTO638.jpg","upload\\LOLPHOTO656.jpg","upload\\LOLPHOTO672.jpg","upload\\LOLPHOTO689.jpg","upload\\LOLPHOTO706.jpg","upload\\LOLPHOTO722.jpg","upload\\LOLPHOTO740.jpg","upload\\LOLPHOTO75.jpg","upload\\LOLPHOTO757.jpg","upload\\LOLPHOTO775.jpg","upload\\LOLPHOTO794.jpg","upload\\LOLPHOTO811.jpg","upload\\LOLPHOTO829.jpg","upload\\LOLPHOTO846.jpg","upload\\LOLPHOTO864.jpg","upload\\LOLPHOTO880.jpg","upload\\LOLPHOTO896.jpg","upload\\LOLPHOTO91.jpg","upload\\LOLPHOTO913.jpg","upload\\LOLPHOTO933.jpg","upload\\LOLPHOTO950.jpg","upload\\LOLPHOTO968.jpg","upload\\LOLPHOTO985.jpg"};
		String goods_mes="���ǳ�����һ���С�Ӣ�����ˡ�����֯��Ŀ�����ڼල�����������η�������������λ��ս��ѧԺ��Ӣ�����˻��������������ʵ���ǵ�½����Ȩ�������֯���������������η��������Ľ����Ӣ�����˾���������Ҫ���������۶�����ͨ���ر����������������صľ�����������ӵ�в�ͬ�������ٻ����Ǹ����ٻ�һ��Ӣ�ۣ���ЩӢ���������û��������ʶ��С������ս������ЩС���ɳ����ٻ���ͨ���ٻ��ڵ����졣";
		
		
		//System.out.println("goods [goods_code="
		//		+ goods_code.length + ", goods_name=" + goods_name.length + ", goods_img=" + goods_img.length + "]");
		
		;
		for(int i=0;i<goods_code.length;i++){
			Connection conn = null;
			try {
				conn = ConnectionManager.getConnection();

				PreparedStatement ps = conn.prepareStatement("insert into goods(type_id,supplier_id ,"
						+ "goods_code, goods_name,goods_count, goods_price ," 
						+"goods_img, goods_mes) values(?,?,?,?,?,?,?,?)");
				
				ps.setInt(1,6);
				ps.setInt(2,6);
				ps.setString(3,goods_code[i]);
				ps.setString(4,goods_name[i]);
				ps.setInt(5,i);
				ps.setFloat(6,6300);
				ps.setString(7,goods_img[i]);
				ps.setString(8,goods_mes);
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionManager.closeConnection(conn);
			}
			
			
		}
		
	}}

