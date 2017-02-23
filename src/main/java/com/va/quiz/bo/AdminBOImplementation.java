
package com.va.quiz.bo;

import com.va.quiz.dao.AdminDAO;
import com.va.quiz.dto.Admin;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class AdminBOImplementation implements AdminBO {
	AdminDAO dao;

	public Admin getAdmin(Admin admin) {
		admin = dao.getAdmin(admin);
		return admin;
	}

	public void setDao(AdminDAO dao) {
		this.dao = dao;
	}
}