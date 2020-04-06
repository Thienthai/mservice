/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sevice.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Guestbook}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Guestbook
 * @generated
 */
public class GuestbookWrapper
	extends BaseModelWrapper<Guestbook>
	implements Guestbook, ModelWrapper<Guestbook> {

	public GuestbookWrapper(Guestbook guestbook) {
		super(guestbook);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("myId", getMyId());
		attributes.put("name", getName());
		attributes.put("myDate", getMyDate());
		attributes.put("message", getMessage());
		attributes.put("createdId", getCreatedId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long myId = (Long)attributes.get("myId");

		if (myId != null) {
			setMyId(myId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String myDate = (String)attributes.get("myDate");

		if (myDate != null) {
			setMyDate(myDate);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Long createdId = (Long)attributes.get("createdId");

		if (createdId != null) {
			setCreatedId(createdId);
		}
	}

	/**
	 * Returns the created ID of this guestbook.
	 *
	 * @return the created ID of this guestbook
	 */
	@Override
	public long getCreatedId() {
		return model.getCreatedId();
	}

	/**
	 * Returns the message of this guestbook.
	 *
	 * @return the message of this guestbook
	 */
	@Override
	public String getMessage() {
		return model.getMessage();
	}

	/**
	 * Returns the my date of this guestbook.
	 *
	 * @return the my date of this guestbook
	 */
	@Override
	public String getMyDate() {
		return model.getMyDate();
	}

	/**
	 * Returns the my ID of this guestbook.
	 *
	 * @return the my ID of this guestbook
	 */
	@Override
	public long getMyId() {
		return model.getMyId();
	}

	/**
	 * Returns the name of this guestbook.
	 *
	 * @return the name of this guestbook
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this guestbook.
	 *
	 * @return the primary key of this guestbook
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the created ID of this guestbook.
	 *
	 * @param createdId the created ID of this guestbook
	 */
	@Override
	public void setCreatedId(long createdId) {
		model.setCreatedId(createdId);
	}

	/**
	 * Sets the message of this guestbook.
	 *
	 * @param message the message of this guestbook
	 */
	@Override
	public void setMessage(String message) {
		model.setMessage(message);
	}

	/**
	 * Sets the my date of this guestbook.
	 *
	 * @param myDate the my date of this guestbook
	 */
	@Override
	public void setMyDate(String myDate) {
		model.setMyDate(myDate);
	}

	/**
	 * Sets the my ID of this guestbook.
	 *
	 * @param myId the my ID of this guestbook
	 */
	@Override
	public void setMyId(long myId) {
		model.setMyId(myId);
	}

	/**
	 * Sets the name of this guestbook.
	 *
	 * @param name the name of this guestbook
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this guestbook.
	 *
	 * @param primaryKey the primary key of this guestbook
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected GuestbookWrapper wrap(Guestbook guestbook) {
		return new GuestbookWrapper(guestbook);
	}

}