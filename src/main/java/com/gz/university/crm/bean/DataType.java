package com.gz.university.crm.bean;

import org.apache.commons.lang3.StringUtils;

public class DataType {
	/**
	 * 该功能完成将String类型的数组转化成Integer类型的数组
	 * 
	 * @param ids
	 * @return
	 */
	public static Integer[] convertStringArrayToIntegerArray(String[] ids) {
		// TODO Auto-generated method stub
		if (ids != null && ids.length > 0) {
			Integer[] result = new Integer[ids.length];
			for (int i = 0; i < result.length; i++) {
				if (StringUtils.isNotBlank(ids[i])) {
					result[i] = Integer.parseInt(ids[i]);
				}
			}
			return result;
		}
		return null;
	}

}
