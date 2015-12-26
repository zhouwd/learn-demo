package com.joe.jade4j.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joe.jade4j.pojo.Book;
import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.FileTemplateLoader;
import de.neuland.jade4j.template.JadeTemplate;
import de.neuland.jade4j.template.TemplateLoader;


public class JadeServlet extends HttpServlet {

	public JadeServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		URL url = JadeServlet.class.getClassLoader().getResource("/");
		File file = new File(url.getPath());
		TemplateLoader loader = new FileTemplateLoader(file.getPath(), "UTF-8");
		JadeConfiguration config = new JadeConfiguration();
		config.setTemplateLoader(loader);
		JadeTemplate template = config.getTemplate("/index");
		String html = Jade4J.render(template, getMap());

		System.out.println(html);
		out.write(html);
		out.flush();
		out.close();
	}

	private Map<String, Object> getMap() {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("The Hitchhiker's Guide to the Galaxy", 5.70, true));
		books.add(new Book("Life, the Universe and Everything", 5.60, false));
		books.add(new Book("The Restaurant at the End of the Universe", 5.40, true));

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("books", books);
		model.put("pageName", "My Bookshelf");
		return  model;
	}


}