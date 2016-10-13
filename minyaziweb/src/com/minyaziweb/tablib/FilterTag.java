package com.minyaziweb.tablib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.minyaziutils.filterutil.StringFilter;
import com.minyaziutils.filterutil.StringFilterFactory;

/**
 * 字符过滤器Tag<br>
 * 
 * @author minyazi
 */
public class FilterTag extends TagSupport {
	
	private static final long serialVersionUID = 1L;
	
	// 使用说明：<s:filter value="test" filter="html,upper" />
	
	private String value;
	private String chain;
	
	public FilterTag() {
		
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setChain(String chain) {
		this.chain = chain;
	}

	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			StringFilter stringFilter = StringFilterFactory.getInstance().getStringFilterChain(chain);
			value = stringFilter.filter(value);
			out.print(value == null ? "" : value);
		} catch (IOException e) {
			throw new JspException(e.getMessage(), e);
		}
		return EVAL_PAGE;
	}
	
	public int doEndTag() throws JspException {
		return SKIP_BODY;
	}
	
}
