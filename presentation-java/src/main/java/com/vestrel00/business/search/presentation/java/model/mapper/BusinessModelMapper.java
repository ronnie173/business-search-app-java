/*
 * Copyright 2017 Vandolf Estrellado
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vestrel00.business.search.presentation.java.model.mapper;

import com.vestrel00.business.search.domain.Business;
import com.vestrel00.business.search.domain.Coordinates;
import com.vestrel00.business.search.domain.Location;
import com.vestrel00.business.search.presentation.java.model.BusinessModel;
import com.vestrel00.business.search.presentation.java.model.CoordinatesModel;
import com.vestrel00.business.search.presentation.java.model.LocationModel;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Maps {@link BusinessModel} to {@link Business} and vice versa.
 */
@Singleton
final class BusinessModelMapper implements ModelMapper<BusinessModel, Business> {

    private final ModelMapper<LocationModel, Location> locationModelMapper;
    private final ModelMapper<CoordinatesModel, Coordinates> coordinatesEntityMapper;

    @Inject
    BusinessModelMapper(LocationModelMapper locationModelMapper,
                        CoordinatesModelMapper coordinatesEntityMapper) {
        this.locationModelMapper = locationModelMapper;
        this.coordinatesEntityMapper = coordinatesEntityMapper;
    }

    @Override
    public Business map(BusinessModel businessModel) {
        return Business.builder()
                .id(businessModel.id())
                .name(businessModel.name())
                .phoneNumber(businessModel.phoneNumber())
                .imageUrl(businessModel.imageUrl())
                .price(businessModel.price())
                .rating(businessModel.rating())
                .closed(businessModel.closed())
                .location(locationModelMapper.map(businessModel.locationModel()))
                .coordinates(coordinatesEntityMapper.map(businessModel.coordinatesModel()))
                .build();
    }

    @Override
    public BusinessModel map(Business business) {
        return BusinessModel.builder()
                .id(business.id())
                .name(business.name())
                .phoneNumber(business.phoneNumber())
                .imageUrl(business.imageUrl())
                .price(business.price())
                .rating(business.rating())
                .closed(business.closed())
                .locationModel(locationModelMapper.map(business.location()))
                .coordinatesModel(coordinatesEntityMapper.map(business.coordinates()))
                .build();
    }
}