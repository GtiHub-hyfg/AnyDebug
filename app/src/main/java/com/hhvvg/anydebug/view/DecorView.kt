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

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.widget.FrameLayout
import com.hhvvg.anydebug.utils.Logger

class DecorView(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) :
    FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    constructor(context: Context)
            : this(context, null)

    constructor(context: Context, attrs: AttributeSet?)

            : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : this(context, attrs, defStyleAttr, 0)

    private var backInvokedCallback: OnBackInvokedCallback? = null


    fun setOnBackInvokedCallback(listener: OnBackInvokedCallback) {
        backInvokedCallback = listener
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (event.action == KeyEvent.ACTION_UP && event.keyCode == KeyEvent.KEYCODE_BACK) {
            backInvokedCallback?.onBackInvoked()
            return true
        }
        return super.dispatchKeyEvent(event)
    }
}