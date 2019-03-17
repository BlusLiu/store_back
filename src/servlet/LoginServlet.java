package servlet;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import dao.LoginDao;
import dto.UserDTO;

/**
 * Servlet implementation class api
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("�Ѿ�����LoginSevlet");
		//����С���򴫹�����account��password
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		UserDTO user = new UserDTO(account,password);
		LoginDao logindao = new LoginDao();
		//��ʼ��Ϊfalse
		Boolean isLogin=false;
		try {
			//�ж��Ƿ��½�ɹ�
			isLogin = logindao.Login(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,String> map=new HashMap<String,String>();
		if(isLogin) map.put("message", "ok");
		else map.put("message", "err");
		//Ҫ��Mapת��ΪJSON���ſ��Դ����ݷ���С����
		JSONObject mapObject=JSONObject.fromObject(map);
		System.out.println("mapObject:"+mapObject.toString());
		//�ӷ�������mapObject���ݵ�С����
		response.getWriter().write(mapObject.toString());  			
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


