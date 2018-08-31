package com.itheima.web.bos.action.base;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.itheima.bos.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 表现层通用实现
 * 
 * @author Dragon
 *
 * @param <T>
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	public static final String HOME = "home";
	public static final String LIST = "list";
	/**
	 * 分页对象
	 */
	protected PageBean<T> pageBean = new PageBean<T>();
	/**
	 * 查询条件
	 */
	protected DetachedCriteria detachedCriteria;
	/**
	 * 序列化常数
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 模型对象
	 */
	protected T model;

	/**
	 * 通过构造方法动态获取实体类型，通过反射创建model对象
	 */
	public BaseAction() throws InstantiationException, IllegalAccessException {
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] types = superclass.getActualTypeArguments();
		@SuppressWarnings("unchecked")
		Class<T> entityClass = (Class<T>) types[0];
		detachedCriteria = DetachedCriteria.forClass(entityClass);
		pageBean.setDetachedCriteria(detachedCriteria);
		/**
		 * 通过反射创建对象
		 */
		try {
			model = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public T getModel() {
		return model;
	}

	public void setPage(Integer page) {
		pageBean.setCurrentPage(page);
	}

	public void setRows(Integer rows) {
		pageBean.setPageSize(rows);
	}

	/**
	 * 将对象转换为json字符串，并且写入前台
	 * 
	 * @param o
	 *            需要转换为json的对象
	 * @param excludes
	 *            不需要转换为json的属性
	 */
	public void javaToJson(Object o, String[] excludes) {
		// 将pageBean转为JSON（json-lib）
		JsonConfig jsonConfig = new JsonConfig();
		if (excludes != null) {
			jsonConfig.setExcludes(excludes);
		}
		String json = JSONObject.fromObject(o, jsonConfig).toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将集合转换为JSON
	 * 
	 * @param TList
	 *            需要转换为JSON的集合
	 * @param excludes
	 *            不需要转换为JSON的字段
	 */
	public void javaToJson(List<?> TList, String[] excludes) {
		JsonConfig jsonConfig = new JsonConfig();
		if (excludes != null) {
			jsonConfig.setExcludes(excludes);
		}
		String json = JSONArray.fromObject(TList, jsonConfig).toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
