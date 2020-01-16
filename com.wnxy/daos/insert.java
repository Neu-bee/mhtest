package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tools.ConnectionManager;

public class insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String goods_code[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","48","50","51","53","54","55","56","57","58","59","60","61","62","63","64","67","68","69","72","74","75","76","77","78","79","80","81","82","83","84","85","86","89","90","91","92","96","98","99","101","102","103","104","105","106","107","110","111","112","113","114","115","117","119","120","121","122","126","127","131","133","134","136","141","142","143","145","150","154","157","161","163","164","201","202","203","222","223","235","236","238","240","245","246","254","266","267","268","350","412","420","421","427","429","432","497","498","516","517","518","523","555"};
		String goods_name[]={"黑暗之女 安妮"," 狂战士 奥拉夫"," 正义巨像 加里奥"," 卡牌大师 崔斯特"," 德邦总管 赵信"," 无畏战车 厄加特"," 诡术妖姬 乐芙兰"," 猩红收割者 弗拉基米尔"," 末日使者 费德提克"," 正义天使 凯尔"," 无极剑圣 易"," 牛头酋长 阿利斯塔"," 符文法师 瑞兹"," 亡灵战神 赛恩"," 战争女神 希维尔"," 众星之子 索拉卡"," 迅捷斥候 提莫"," 麦林炮手 崔丝塔娜"," 祖安怒兽 沃里克"," 雪原双子 努努和威朗普"," 赏金猎人 厄运小姐"," 寒冰射手 艾希"," 蛮族之王 泰达米尔"," 武器大师 贾克斯"," 堕落天使 莫甘娜"," 时光守护者 基兰"," 炼金术士 辛吉德"," 痛苦之拥 伊芙琳"," 瘟疫之源 图奇"," 死亡颂唱者 卡尔萨斯"," 虚空恐惧 科加斯"," 殇之木乃伊 阿木木"," 披甲龙龟 拉莫斯"," 冰晶凤凰 艾尼维亚"," 恶魔小丑 萨科"," 祖安狂人 蒙多医生"," 琴瑟仙女 娑娜"," 虚空行者 卡萨丁"," 刀锋舞者 艾瑞莉娅"," 风暴之怒 迦娜"," 海洋之灾 普朗克"," 英勇投弹手 库奇"," 天启者 卡尔玛"," 瓦洛兰之盾 塔里克"," 邪恶小法师 维迦"," 巨魔之王 特朗德尔"," 诺克萨斯统领 斯维因"," 皮城女警 凯特琳"," 蒸汽机器人 布里茨"," 熔岩巨兽 墨菲特"," 不祥之刃 卡特琳娜"," 永恒梦魇 魔腾"," 扭曲树精 茂凯"," 荒漠屠夫 雷克顿"," 德玛西亚皇子 嘉文四世"," 蜘蛛女皇 伊莉丝"," 发条魔灵 奥莉安娜"," 齐天大圣 孙悟空"," 复仇焰魂 布兰德"," 盲僧 李青"," 暗夜猎手 薇恩"," 机械公敌 兰博"," 魔蛇之拥 卡西奥佩娅"," 水晶先锋 斯卡纳"," 大发明家 黑默丁格"," 沙漠死神 内瑟斯"," 狂野女猎手 奈德丽"," 兽灵行者 乌迪尔"," 圣锤之毅 波比"," 酒桶 古拉加斯"," 不屈之枪 潘森"," 探险家 伊泽瑞尔"," 铁铠冥魂 莫德凯撒"," 牧魂人 约里克"," 离群之刺 阿卡丽"," 狂暴之心 凯南"," 德玛西亚之力 盖伦"," 曙光女神 蕾欧娜"," 虚空先知 玛尔扎哈"," 刀锋之影 泰隆"," 放逐之刃 锐雯"," 深渊巨口 克格莫"," 暮光之眼 慎"," 光辉女郎 拉克丝"," 远古巫灵 泽拉斯"," 龙血武姬 希瓦娜"," 九尾妖狐 阿狸"," 法外狂徒 格雷福斯"," 潮汐海灵 菲兹"," 雷霆咆哮 沃利贝尔"," 傲之追猎者 雷恩加尔"," 惩戒之箭 韦鲁斯"," 深海泰坦 诺提勒斯"," 机械先驱 维克托"," 北地之怒 瑟庄妮"," 无双剑姬 菲奥娜"," 爆破鬼才 吉格斯"," 仙灵女巫 璐璐"," 荣耀行刑官 德莱文"," 战争之影 赫卡里姆"," 虚空掠夺者 卡兹克"," 诺克萨斯之手 德莱厄斯"," 未来守护者 杰斯"," 冰霜女巫 丽桑卓"," 皎月女神 黛安娜"," 德玛西亚之翼 奎因"," 暗黑元首 辛德拉"," 铸星龙王 奥瑞利安·索尔"," 影流之镰 凯隐"," 暮光星灵 佐伊"," 荆棘之兴 婕拉"," 虚空之女 卡莎"," 迷失之牙 纳尔"," 生化魔人 扎克"," 疾风剑豪 亚索"," 虚空之眼 维克兹"," 岩雀 塔莉垭"," 青钢影 卡蜜尔"," 弗雷尔卓德之心 布隆"," 戏命师 烬"," 永猎双子 千珏"," 暴走萝莉 金克丝"," 河流之王 塔姆"," 涤魂圣枪 赛娜"," 圣枪游侠 卢锡安"," 影流之主 劫"," 暴怒骑士 克烈"," 时间刺客 艾克"," 元素女皇 奇亚娜"," 皮城执法官 蔚"," 暗裔剑魔 亚托克斯"," 唤潮鲛姬 娜美"," 沙漠皇帝 阿兹尔"," 魔法猫咪 悠米"," 魂锁典狱长 锤石"," 海兽祭司 俄洛伊"," 虚空遁地兽 雷克塞"," 翠神 艾翁"," 复仇之矛 卡莉丝塔"," 星界游神 巴德"," 幻翎 洛"," 逆羽 霞"," 山隐之焰 奥恩"," 解脱者 塞拉斯"," 万花通灵 妮蔻"," 残月之肃 厄斐琉斯"," 血港鬼影 派克"};
		
		String goods_img[]={"upload\\LOLPHOTO1002.jpg","upload\\LOLPHOTO1016.jpg","upload\\LOLPHOTO1032.jpg","upload\\LOLPHOTO1048.jpg","upload\\LOLPHOTO1067.jpg","upload\\LOLPHOTO107.jpg","upload\\LOLPHOTO1084.jpg","upload\\LOLPHOTO1102.jpg","upload\\LOLPHOTO1119.jpg","upload\\LOLPHOTO1137.jpg","upload\\LOLPHOTO1154.jpg","upload\\LOLPHOTO1170.jpg","upload\\LOLPHOTO1186.jpg","upload\\LOLPHOTO1202.jpg","upload\\LOLPHOTO1219.jpg","upload\\LOLPHOTO1237.jpg","upload\\LOLPHOTO1253.jpg","upload\\LOLPHOTO126.jpg","upload\\LOLPHOTO1270.jpg","upload\\LOLPHOTO1286.jpg","upload\\LOLPHOTO13.jpg","upload\\LOLPHOTO1304.jpg","upload\\LOLPHOTO1321.jpg","upload\\LOLPHOTO1339.jpg","upload\\LOLPHOTO1355.jpg","upload\\LOLPHOTO1371.jpg","upload\\LOLPHOTO1388.jpg","upload\\LOLPHOTO1403.jpg","upload\\LOLPHOTO1420.jpg","upload\\LOLPHOTO143.jpg","upload\\LOLPHOTO1438.jpg","upload\\LOLPHOTO1456.jpg","upload\\LOLPHOTO1473.jpg","upload\\LOLPHOTO1492.jpg","upload\\LOLPHOTO1509.jpg","upload\\LOLPHOTO1528.jpg","upload\\LOLPHOTO1548.jpg","upload\\LOLPHOTO1566.jpg","upload\\LOLPHOTO1585.jpg","upload\\LOLPHOTO159.jpg","upload\\LOLPHOTO1603.jpg","upload\\LOLPHOTO1621.jpg","upload\\LOLPHOTO1639.jpg","upload\\LOLPHOTO1657.jpg","upload\\LOLPHOTO1674.jpg","upload\\LOLPHOTO1693.jpg","upload\\LOLPHOTO1712.jpg","upload\\LOLPHOTO1731.jpg","upload\\LOLPHOTO174.jpg","upload\\LOLPHOTO1752.jpg","upload\\LOLPHOTO1770.jpg","upload\\LOLPHOTO1788.jpg","upload\\LOLPHOTO1806.jpg","upload\\LOLPHOTO1825.jpg","upload\\LOLPHOTO1843.jpg","upload\\LOLPHOTO1865.jpg","upload\\LOLPHOTO1882.jpg","upload\\LOLPHOTO1899.jpg","upload\\LOLPHOTO1916.jpg","upload\\LOLPHOTO192.jpg","upload\\LOLPHOTO1933.jpg","upload\\LOLPHOTO1950.jpg","upload\\LOLPHOTO1967.jpg","upload\\LOLPHOTO1984.jpg","upload\\LOLPHOTO2002.jpg","upload\\LOLPHOTO2018.jpg","upload\\LOLPHOTO2035.jpg","upload\\LOLPHOTO2055.jpg","upload\\LOLPHOTO2070.jpg","upload\\LOLPHOTO208.jpg","upload\\LOLPHOTO2087.jpg","upload\\LOLPHOTO2105.jpg","upload\\LOLPHOTO2122.jpg","upload\\LOLPHOTO2139.jpg","upload\\LOLPHOTO2157.jpg","upload\\LOLPHOTO2173.jpg","upload\\LOLPHOTO2190.jpg","upload\\LOLPHOTO2207.jpg","upload\\LOLPHOTO2225.jpg","upload\\LOLPHOTO224.jpg","upload\\LOLPHOTO2242.jpg","upload\\LOLPHOTO2261.jpg","upload\\LOLPHOTO2278.jpg","upload\\LOLPHOTO2296.jpg","upload\\LOLPHOTO2313.jpg","upload\\LOLPHOTO2331.jpg","upload\\LOLPHOTO2349.jpg","upload\\LOLPHOTO2368.jpg","upload\\LOLPHOTO2383.jpg","upload\\LOLPHOTO2402.jpg","upload\\LOLPHOTO241.jpg","upload\\LOLPHOTO2419.jpg","upload\\LOLPHOTO2433.jpg","upload\\LOLPHOTO2447.jpg","upload\\LOLPHOTO2464.jpg","upload\\LOLPHOTO2481.jpg","upload\\LOLPHOTO2498.jpg","upload\\LOLPHOTO2517.jpg","upload\\LOLPHOTO2534.jpg","upload\\LOLPHOTO258.jpg","upload\\LOLPHOTO274.jpg","upload\\LOLPHOTO28.jpg","upload\\LOLPHOTO292.jpg","upload\\LOLPHOTO309.jpg","upload\\LOLPHOTO329.jpg","upload\\LOLPHOTO347.jpg","upload\\LOLPHOTO363.jpg","upload\\LOLPHOTO381.jpg","upload\\LOLPHOTO398.jpg","upload\\LOLPHOTO415.jpg","upload\\LOLPHOTO432.jpg","upload\\LOLPHOTO44.jpg","upload\\LOLPHOTO449.jpg","upload\\LOLPHOTO466.jpg","upload\\LOLPHOTO482.jpg","upload\\LOLPHOTO501.jpg","upload\\LOLPHOTO518.jpg","upload\\LOLPHOTO536.jpg","upload\\LOLPHOTO553.jpg","upload\\LOLPHOTO571.jpg","upload\\LOLPHOTO587.jpg","upload\\LOLPHOTO60.jpg","upload\\LOLPHOTO605.jpg","upload\\LOLPHOTO621.jpg","upload\\LOLPHOTO638.jpg","upload\\LOLPHOTO656.jpg","upload\\LOLPHOTO672.jpg","upload\\LOLPHOTO689.jpg","upload\\LOLPHOTO706.jpg","upload\\LOLPHOTO722.jpg","upload\\LOLPHOTO740.jpg","upload\\LOLPHOTO75.jpg","upload\\LOLPHOTO757.jpg","upload\\LOLPHOTO775.jpg","upload\\LOLPHOTO794.jpg","upload\\LOLPHOTO811.jpg","upload\\LOLPHOTO829.jpg","upload\\LOLPHOTO846.jpg","upload\\LOLPHOTO864.jpg","upload\\LOLPHOTO880.jpg","upload\\LOLPHOTO896.jpg","upload\\LOLPHOTO91.jpg","upload\\LOLPHOTO913.jpg","upload\\LOLPHOTO933.jpg","upload\\LOLPHOTO950.jpg","upload\\LOLPHOTO968.jpg","upload\\LOLPHOTO985.jpg"};
		String goods_mes="他们成立了一个叫“英雄联盟”的组织，目的在于监督瓦罗兰的政治纷争得以有序处理。位于战争学院的英雄联盟获得了瓦罗兰政治实体们的陆续授权，这个组织将管理处置所有政治纷争带来的结果，英雄联盟决定所有主要的政治争论都必须通过特别设立在瓦罗兰各地的竞技场来处理。拥有不同政见的召唤者们各自召唤一个英雄，这些英雄们则带领没有心智意识的小兵进行战斗，这些小兵由初阶召唤者通过召唤节点制造。";
		
		
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

