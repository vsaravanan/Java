package com.raistudies.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;

public class ResigtrationAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm regisForm = (DynaActionForm)form;
		String name = regisForm.get("name").toString();
		String username = regisForm.get("username").toString();
		String pass = regisForm.get("password").toString();
		String rePass = regisForm.get("rePassword").toString();
		ActionErrors errors = new ActionErrors();
		if(isEmpty(name))
			errors.add("name", new ActionMessage("error.field.empty", "Name"));
		if(isEmpty(username))
			errors.add("username", new ActionMessage("error.field.empty", "Username"));
		if(isEmpty(pass))
			errors.add("password", new ActionMessage("error.field.empty", "Password"));
		if(isEmpty(rePass))
			errors.add("rePassword", new ActionMessage("error.field.empty", "Retype Password"));
		if(errors.isEmpty() && !pass.equals(rePass))
			errors.add("rePassword", new ActionMessage("error.field.passNotSame"));
		if(errors.isEmpty())
			return mapping.findForward("success");
		else
		{
			saveErrors(request, errors);
			return mapping.getInputForward();
		}
	}
	
	private boolean isEmpty(String value){
		if(value == null || value.trim().equals(""))
			return true;
		else
			return false;
	}
}
