package servlets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCodeServlet
 */
@WebServlet("/front/checkCode.do")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Random random=new Random();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		         //�ڴ�ͼƬ����(TYPE_INT_BGR ѡ��ͼƬģʽRGBģʽ)
		        BufferedImage image = new BufferedImage(90,30,BufferedImage.TYPE_INT_BGR);
		         //�õ�����
		        Graphics graphics = image.getGraphics();
		        //��֮ǰҪ������ɫ�����û�����ɫ
		        graphics.setColor(Color.yellow);
		        //����������ָ��Ҫ����������������
		        graphics.fillRect(0,0,90,30);
		        //Ϊ�˷�ֹ�ڿ����ͨ��ɨ�����ʶ����֤�롣Ҫ����֤��ͼƬ�ϼӸ�����
		        //����������һ����graphics.drawLine();
		        //���ɸ�����
		        for (int i=0;i<20;i++){
		            //��ɫҲҪ���������ÿ���������ɫ��
		            graphics.setColor(getRandomColor());
		            int x1=random.nextInt(90);
		            int y1=random.nextInt(30);
		            int x2=random.nextInt(90);
		            int y2=random.nextInt(30);
		            graphics.drawLine(x1,y1,x2,y2);
		        } 
		        
		        //ƴ��4����֤�룬����ͼƬ��
		        //�ַ������е��ַ����ǿ��ܻ������ͼƬ�е��ַ�
		        char [] arrays={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		        //builder���������֤���е��ַ�
		        StringBuilder builder = new StringBuilder();
		        //�õ��ĸ���֤��
		        for(int i=0;i<4;i++){
		               //�����ַ�����ɫ
		               //�����һ��������±�λ��
		                int index=random.nextInt(arrays.length);
		                 //���������õ���Ӧ����ĸ׷�ӵ��ַ�����
		                builder.append(arrays[index]);
		          }
		        
		        
		          //����session�������ɵ���֤���ַ���������ΪcheckCode������session��
                
		        request.getSession().setAttribute("checkCode",builder.toString());
		          //��4���ַ�����ͼƬ��graphics.drawString(str ,x,y);һ���ַ�һ���ַ���
		        
		        
		        //���ĸ��ַ�����ͼƬ��
		        graphics.setFont(new Font("΢���ź�", Font.BOLD, 25));
		        //ÿѭ��һ�Σ���һ���ַ�
		        for (int i=0;i<builder.toString().length();i++)
		        {
		            graphics.setColor(getRandomColor());
		          
		            char item=builder.toString().charAt(i);
		            //���һ������ָ���ֵĻ��ߵ������꣬���ߴ�������ֵ��ķ�֮����λ�á�
		            graphics.drawString(item+"",5+(i*22),25); 
		            
		        }
		  
		  
		        //����ڴ�ͼƬ���������������������ͻ����������
		        ImageIO.write(image,"png",response.getOutputStream());
	}
	
	private Color getRandomColor(){
        int r=random.nextInt(256);
         int g=random.nextInt(256);
         int b=random.nextInt(256);
        return new Color(r,g,b); 
  
     }
}
