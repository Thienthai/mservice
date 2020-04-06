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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GuestbookSoap implements Serializable {

	public static GuestbookSoap toSoapModel(Guestbook model) {
		GuestbookSoap soapModel = new GuestbookSoap();

		soapModel.setMyId(model.getMyId());
		soapModel.setName(model.getName());
		soapModel.setMyDate(model.getMyDate());
		soapModel.setMessage(model.getMessage());
		soapModel.setCreatedId(model.getCreatedId());

		return soapModel;
	}

	public static GuestbookSoap[] toSoapModels(Guestbook[] models) {
		GuestbookSoap[] soapModels = new GuestbookSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GuestbookSoap[][] toSoapModels(Guestbook[][] models) {
		GuestbookSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GuestbookSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GuestbookSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GuestbookSoap[] toSoapModels(List<Guestbook> models) {
		List<GuestbookSoap> soapModels = new ArrayList<GuestbookSoap>(
			models.size());

		for (Guestbook model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GuestbookSoap[soapModels.size()]);
	}

	public GuestbookSoap() {
	}

	public long getPrimaryKey() {
		return _myId;
	}

	public void setPrimaryKey(long pk) {
		setMyId(pk);
	}

	public long getMyId() {
		return _myId;
	}

	public void setMyId(long myId) {
		_myId = myId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getMyDate() {
		return _myDate;
	}

	public void setMyDate(String myDate) {
		_myDate = myDate;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public long getCreatedId() {
		return _createdId;
	}

	public void setCreatedId(long createdId) {
		_createdId = createdId;
	}

	private long _myId;
	private String _name;
	private String _myDate;
	private String _message;
	private long _createdId;

}