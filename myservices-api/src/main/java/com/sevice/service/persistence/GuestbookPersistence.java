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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.sevice.exception.NoSuchGuestbookException;
import com.sevice.model.Guestbook;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the guestbook service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GuestbookUtil
 * @generated
 */
@ProviderType
public interface GuestbookPersistence extends BasePersistence<Guestbook> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GuestbookUtil} to access the guestbook persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the guestbook in the entity cache if it is enabled.
	 *
	 * @param guestbook the guestbook
	 */
	public void cacheResult(Guestbook guestbook);

	/**
	 * Caches the guestbooks in the entity cache if it is enabled.
	 *
	 * @param guestbooks the guestbooks
	 */
	public void cacheResult(java.util.List<Guestbook> guestbooks);

	/**
	 * Creates a new guestbook with the primary key. Does not add the guestbook to the database.
	 *
	 * @param myId the primary key for the new guestbook
	 * @return the new guestbook
	 */
	public Guestbook create(long myId);

	/**
	 * Removes the guestbook with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myId the primary key of the guestbook
	 * @return the guestbook that was removed
	 * @throws NoSuchGuestbookException if a guestbook with the primary key could not be found
	 */
	public Guestbook remove(long myId) throws NoSuchGuestbookException;

	public Guestbook updateImpl(Guestbook guestbook);

	/**
	 * Returns the guestbook with the primary key or throws a <code>NoSuchGuestbookException</code> if it could not be found.
	 *
	 * @param myId the primary key of the guestbook
	 * @return the guestbook
	 * @throws NoSuchGuestbookException if a guestbook with the primary key could not be found
	 */
	public Guestbook findByPrimaryKey(long myId)
		throws NoSuchGuestbookException;

	/**
	 * Returns the guestbook with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param myId the primary key of the guestbook
	 * @return the guestbook, or <code>null</code> if a guestbook with the primary key could not be found
	 */
	public Guestbook fetchByPrimaryKey(long myId);

	/**
	 * Returns all the guestbooks.
	 *
	 * @return the guestbooks
	 */
	public java.util.List<Guestbook> findAll();

	/**
	 * Returns a range of all the guestbooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbooks
	 * @param end the upper bound of the range of guestbooks (not inclusive)
	 * @return the range of guestbooks
	 */
	public java.util.List<Guestbook> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the guestbooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbooks
	 * @param end the upper bound of the range of guestbooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of guestbooks
	 */
	public java.util.List<Guestbook> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Guestbook>
			orderByComparator);

	/**
	 * Returns an ordered range of all the guestbooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbooks
	 * @param end the upper bound of the range of guestbooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of guestbooks
	 */
	public java.util.List<Guestbook> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Guestbook>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the guestbooks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of guestbooks.
	 *
	 * @return the number of guestbooks
	 */
	public int countAll();

}