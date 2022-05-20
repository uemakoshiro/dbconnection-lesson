package jp.co.axiz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.axiz.entity.Product;
import jp.co.axiz.service.ProductService;
/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}
    	
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    	request.setCharacterEncoding("UTF-8");
    	String strId = request.getParameter("id");
    	String name = request.getParameter("name");
    	String price = request.getParameter("price");
    	
    	if(strId.isEmpty() || name.isEmpty() || price.isEmpty()) {
    		int flag = 0;
    		if(strId.isEmpty()) {
    			flag += 100;
    		}if(name.isEmpty()) {
    			flag += 10;
    		}if(price.isEmpty()) {
    			flag += 1;
    		}
    		request.setAttribute("flag", flag);
    		request.getRequestDispatcher("update.jsp").forward(request, response);
    	}
    	
    	Product pd = new Product(Integer.parseInt(strId),name,Integer.parseInt(price));
    	
    	Product before = new ProductService().findId(strId);
    	int result = new ProductService().update(pd);
    	Product after = new ProductService().findId(strId);
    	//System.out.println(result);
    	if(result == 1) {
    		request.setAttribute("before", before);
    		request.setAttribute("after", after);
    		request.getRequestDispatcher("updateResult.jsp").forward(request, response);
    	}else {
    		request.setAttribute("msg", "対象のデータはありません");
    		request.getRequestDispatcher("update.jsp").forward(request, response);
    	}
    }
}
