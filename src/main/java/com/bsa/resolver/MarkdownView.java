package com.bsa.resolver;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.web.servlet.view.AbstractTemplateView;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;

public class MarkdownView extends AbstractTemplateView {
	private Parser parser;
	private HtmlRenderer renderer;
	
	public MarkdownView() {
		MutableDataSet mutableDataSet = new MutableDataSet();
		parser = Parser.builder(mutableDataSet).build();
		renderer = HtmlRenderer.builder(mutableDataSet).build();
	}
	
	@Override
	protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		PrintWriter writer = response.getWriter();
		writer.append("<html><body>");
		writer.append(getHtmlFromMarkdown());
		writer.append("</body></html>");
	}

	private String getHtmlFromMarkdown() throws URISyntaxException, IOException {
		
		String html = "";
		File resourceFolder = new File("resource");
		if(!resourceFolder.exists()) {
			if(!resourceFolder.mkdir()) {
				System.out.println("Dont have permission to create folder resource.!");
				System.exit(0);
			}
		}
		
		File fileMd = new File(resourceFolder.getAbsolutePath() + "\\" + getUrl());

		if (fileMd.exists()) {
			String markdown = FileUtils.readFileToString(fileMd, StandardCharsets.UTF_8);
			Node document = parser.parse(markdown);
			html = renderer.render(document);
		} else {
			html = "Data Not Found !!";
		}

		return html;
	}
}
