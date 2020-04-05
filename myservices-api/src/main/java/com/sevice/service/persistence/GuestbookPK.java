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

package com.sevice.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GuestbookPK implements Comparable<GuestbookPK>, Serializable {

	public long myId;
	public long createdId;

	public GuestbookPK() {
	}

	public GuestbookPK(long myId, long createdId) {
		this.myId = myId;
		this.createdId = createdId;
	}

	public long getMyId() {
		return myId;
	}

	public void setMyId(long myId) {
		this.myId = myId;
	}

	public long getCreatedId() {
		return createdId;
	}

	public void setCreatedId(long createdId) {
		this.createdId = createdId;
	}

	@Override
	public int compareTo(GuestbookPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (myId < pk.myId) {
			value = -1;
		}
		else if (myId > pk.myId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (createdId < pk.createdId) {
			value = -1;
		}
		else if (createdId > pk.createdId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GuestbookPK)) {
			return false;
		}

		GuestbookPK pk = (GuestbookPK)obj;

		if ((myId == pk.myId) && (createdId == pk.createdId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, myId);
		hashCode = HashUtil.hash(hashCode, createdId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("myId=");

		sb.append(myId);
		sb.append(", createdId=");

		sb.append(createdId);

		sb.append("}");

		return sb.toString();
	}

}