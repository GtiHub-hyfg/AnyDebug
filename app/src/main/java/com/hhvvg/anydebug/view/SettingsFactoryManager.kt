/*
 *     Copyright (C) <2024>  <gitofleonardo>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.hhvvg.anydebug.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.hhvvg.anydebug.view.factory.BasicViewFactory
import com.hhvvg.anydebug.view.factory.ImageViewFactory
import com.hhvvg.anydebug.view.factory.TextViewFactory

object SettingsFactoryManager {

    fun createFactory(window: ActivityPreviewWindow, target: View): SettingsFactory {
        return when (target) {
            is TextView -> TextViewFactory(window)
            is ImageView -> ImageViewFactory(window)
            else -> BasicViewFactory(window)
        }
    }

}