/*
 * Copyright (c) 2009 mazzolini at gmail.com
 * This file is part of dbIdeas.
 * 
 * dbIdeas is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * dbIdeas is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with dbIdeas.  If not, see <http://www.gnu.org/licenses/>.
 * 
*/
package dbideas.actions;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import dbideas.IFileUploadAction;

public class ExcelExport implements IFileUploadAction {

	String ex;
	public void setEx(String ex) {
		this.ex = ex;
	}
	public void execute(Map<String, FileItem> fileMap, Map<String,String> parameterMap,
			HttpServletResponse response, EntityManager em, EntityTransaction et)
			throws Exception {
		
		ex=parameterMap.get("ex");
		
		response.setHeader("Pragma" ,"public");
		response.setHeader("Expires", "0"); // set expiration time
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition","attachment;filename=export.xls");
		response.setContentLength(ex.length());
		ServletOutputStream os = response.getOutputStream();
		os.write(ex.getBytes());
		os.flush();
	}

}
