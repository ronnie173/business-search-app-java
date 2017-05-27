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

package com.vestrel00.business.search.presentation.android.mvp.ui.business.list.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.vestrel00.business.search.presentation.android.mvp.ui.business.common.view.BusinessItemViewHolder;

/**
 * The {@link RecyclerView.ViewHolder} for {@link BusinessListAdapter}.
 */
final class BusinessListItemViewHolder extends RecyclerView.ViewHolder {

    private final BusinessItemViewHolder itemViewHolder;

    BusinessListItemViewHolder(View itemView, BusinessItemViewHolder itemViewHolder) {
        super(itemView);
        this.itemViewHolder = itemViewHolder;
    }

    public BusinessItemViewHolder itemViewHolder() {
        return itemViewHolder;
    }
}
