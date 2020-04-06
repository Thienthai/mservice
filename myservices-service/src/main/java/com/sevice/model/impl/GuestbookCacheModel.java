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

package com.sevice.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.sevice.model.Guestbook;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Guestbook in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GuestbookCacheModel
	implements CacheModel<Guestbook>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GuestbookCacheModel)) {
			return false;
		}

		GuestbookCacheModel guestbookCacheModel = (GuestbookCacheModel)obj;

		if (myId == guestbookCacheModel.myId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, myId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{myId=");
		sb.append(myId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", myDate=");
		sb.append(myDate);
		sb.append(", message=");
		sb.append(message);
		sb.append(", createdId=");
		sb.append(createdId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Guestbook toEntityModel() {
		GuestbookImpl guestbookImpl = new GuestbookImpl();

		guestbookImpl.setMyId(myId);

		if (name == null) {
			guestbookImpl.setName("");
		}
		else {
			guestbookImpl.setName(name);
		}

		if (myDate == null) {
			guestbookImpl.setMyDate("");
		}
		else {
			guestbookImpl.setMyDate(myDate);
		}

		if (message == null) {
			guestbookImpl.setMessage("");
		}
		else {
			guestbookImpl.setMessage(message);
		}

		guestbookImpl.setCreatedId(createdId);

		guestbookImpl.resetOriginalValues();

		return guestbookImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		myId = objectInput.readLong();
		name = objectInput.readUTF();
		myDate = objectInput.readUTF();
		message = objectInput.readUTF();

		createdId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(myId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (myDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(myDate);
		}

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}

		objectOutput.writeLong(createdId);
	}

	public long myId;
	public String name;
	public String myDate;
	public String message;
	public long createdId;

}