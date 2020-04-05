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

package com.sevice.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GuestbookLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GuestbookLocalService
 * @generated
 */
public class GuestbookLocalServiceWrapper
	implements GuestbookLocalService, ServiceWrapper<GuestbookLocalService> {

	public GuestbookLocalServiceWrapper(
		GuestbookLocalService guestbookLocalService) {

		_guestbookLocalService = guestbookLocalService;
	}

	/**
	 * Adds the guestbook to the database. Also notifies the appropriate model listeners.
	 *
	 * @param guestbook the guestbook
	 * @return the guestbook that was added
	 */
	@Override
	public com.sevice.model.Guestbook addGuestbook(
		com.sevice.model.Guestbook guestbook) {

		return _guestbookLocalService.addGuestbook(guestbook);
	}

	/**
	 * Creates a new guestbook with the primary key. Does not add the guestbook to the database.
	 *
	 * @param myId the primary key for the new guestbook
	 * @return the new guestbook
	 */
	@Override
	public com.sevice.model.Guestbook createGuestbook(long myId) {
		return _guestbookLocalService.createGuestbook(myId);
	}

	/**
	 * Deletes the guestbook from the database. Also notifies the appropriate model listeners.
	 *
	 * @param guestbook the guestbook
	 * @return the guestbook that was removed
	 */
	@Override
	public com.sevice.model.Guestbook deleteGuestbook(
		com.sevice.model.Guestbook guestbook) {

		return _guestbookLocalService.deleteGuestbook(guestbook);
	}

	/**
	 * Deletes the guestbook with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myId the primary key of the guestbook
	 * @return the guestbook that was removed
	 * @throws PortalException if a guestbook with the primary key could not be found
	 */
	@Override
	public com.sevice.model.Guestbook deleteGuestbook(long myId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookLocalService.deleteGuestbook(myId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _guestbookLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _guestbookLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sevice.model.impl.GuestbookModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _guestbookLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sevice.model.impl.GuestbookModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _guestbookLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _guestbookLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _guestbookLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sevice.model.Guestbook fetchGuestbook(long myId) {
		return _guestbookLocalService.fetchGuestbook(myId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _guestbookLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the guestbook with the primary key.
	 *
	 * @param myId the primary key of the guestbook
	 * @return the guestbook
	 * @throws PortalException if a guestbook with the primary key could not be found
	 */
	@Override
	public com.sevice.model.Guestbook getGuestbook(long myId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookLocalService.getGuestbook(myId);
	}

	/**
	 * Returns a range of all the guestbooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sevice.model.impl.GuestbookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbooks
	 * @param end the upper bound of the range of guestbooks (not inclusive)
	 * @return the range of guestbooks
	 */
	@Override
	public java.util.List<com.sevice.model.Guestbook> getGuestbooks(
		int start, int end) {

		return _guestbookLocalService.getGuestbooks(start, end);
	}

	/**
	 * Returns the number of guestbooks.
	 *
	 * @return the number of guestbooks
	 */
	@Override
	public int getGuestbooksCount() {
		return _guestbookLocalService.getGuestbooksCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _guestbookLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _guestbookLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the guestbook in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param guestbook the guestbook
	 * @return the guestbook that was updated
	 */
	@Override
	public com.sevice.model.Guestbook updateGuestbook(
		com.sevice.model.Guestbook guestbook) {

		return _guestbookLocalService.updateGuestbook(guestbook);
	}

	@Override
	public GuestbookLocalService getWrappedService() {
		return _guestbookLocalService;
	}

	@Override
	public void setWrappedService(GuestbookLocalService guestbookLocalService) {
		_guestbookLocalService = guestbookLocalService;
	}

	private GuestbookLocalService _guestbookLocalService;

}