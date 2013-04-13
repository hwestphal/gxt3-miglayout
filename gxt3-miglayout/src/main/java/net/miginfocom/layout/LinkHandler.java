/*
 * Copyright (c) 2013, Harald Westphal
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * * Neither the name of the author nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH
 * DAMAGE.
 */
package net.miginfocom.layout;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.google.gwt.core.client.impl.WeakMapping;

/**
 * Re-implementation of the original MigLayout LinkHandler using GWT's
 * {@link WeakMapping}.
 */
public final class LinkHandler {
	public static final int X = 0;
	public static final int Y = 1;
	public static final int WIDTH = 2;
	public static final int HEIGHT = 3;
	public static final int X2 = 4;
	public static final int Y2 = 5;

	private static final String VALUE_KEY_PREFIX = "value!";
	private static final String TEMP_KEY_PREFIX = "temp!";
	private static final String KEYS_KEY = "keys!";

	private LinkHandler() {
	}

	public synchronized static Integer getValue(Object layout, String key, int type) {
		int[] bounds = getTempBounds(layout, key);
		if (bounds != null && bounds[type] != LayoutUtil.NOT_SET) {
			return bounds[type];
		}
		bounds = getBounds(layout, key);
		if (bounds != null && bounds[type] != LayoutUtil.NOT_SET) {
			return bounds[type];
		}
		return null;
	}

	/**
	 * Sets a key that can be linked to from any component.
	 * 
	 * @param layout
	 *            The MigLayout instance
	 * @param key
	 *            The key to link to. This is the same as the ID in a component
	 *            constraint.
	 * @param x
	 *            x
	 * @param y
	 *            y
	 * @param width
	 *            Width
	 * @param height
	 *            Height
	 * @return If the value was changed
	 */
	public synchronized static boolean setBounds(Object layout, String key, int x, int y, int width, int height) {
		return setBounds(layout, key, x, y, width, height, false, false);
	}

	synchronized static boolean setBounds(Object layout, String key, int x, int y, int width, int height, boolean temporary, boolean incCur) {
		int[] old;
		if (temporary) {
			old = getTempBounds(layout, key);
		} else {
			old = getBounds(layout, key);
		}

		if (old == null || !incCur) {
			addKey(layout, key);
			int[] bounds = new int[] { x, y, width, height, x + width, y + height };
			if (temporary) {
				setTempBounds(layout, key, bounds);
			} else {
				setBounds(layout, key, bounds);
			}
			return true;
		}

		if (old[X] == x && old[Y] == y && old[WIDTH] == width && old[HEIGHT] == height) {
			return false;
		}

		boolean changed = false;

		if (x != LayoutUtil.NOT_SET) {
			if (old[X] == LayoutUtil.NOT_SET || x < old[X]) {
				old[X] = x;
				old[WIDTH] = old[X2] - x;
				changed = true;
			}

			if (width != LayoutUtil.NOT_SET) {
				int x2 = x + width;
				if (old[X2] == LayoutUtil.NOT_SET || x2 > old[X2]) {
					old[X2] = x2;
					old[WIDTH] = x2 - old[X];
					changed = true;
				}
			}
		}

		if (y != LayoutUtil.NOT_SET) {
			if (old[Y] == LayoutUtil.NOT_SET || y < old[Y]) {
				old[Y] = y;
				old[HEIGHT] = old[Y2] - y;
				changed = true;
			}

			if (height != LayoutUtil.NOT_SET) {
				int y2 = y + height;
				if (old[Y2] == LayoutUtil.NOT_SET || y2 > old[Y2]) {
					old[Y2] = y2;
					old[HEIGHT] = y2 - old[Y];
					changed = true;
				}
			}
		}

		return changed;
	}

	public synchronized static boolean clearBounds(Object layout, String key) {
		boolean result = getBounds(layout, key) != null;
		setBounds(layout, key, null);
		return result;
	}

	synchronized static void clearTemporaryBounds(Object layout) {
		for (String key : getKeys(layout)) {
			setTempBounds(layout, key, null);
		}
	}

	private static int[] getBounds(Object layout, String key) {
		return (int[]) WeakMapping.get(layout, VALUE_KEY_PREFIX + key);
	}

	private static void setBounds(Object layout, String key, int[] value) {
		WeakMapping.set(layout, VALUE_KEY_PREFIX + key, value);
	}

	private static int[] getTempBounds(Object layout, String key) {
		return (int[]) WeakMapping.get(layout, TEMP_KEY_PREFIX + key);
	}

	private static void setTempBounds(Object layout, String key, int[] value) {
		WeakMapping.set(layout, TEMP_KEY_PREFIX + key, value);
	}

	private static void addKey(Object layout, String key) {
		@SuppressWarnings("unchecked")
		Set<String> keys = (Set<String>) WeakMapping.get(layout, KEYS_KEY);
		if (keys == null) {
			keys = new HashSet<String>();
			WeakMapping.set(layout, KEYS_KEY, keys);
		}
		keys.add(key);
	}

	private static Set<String> getKeys(Object layout) {
		@SuppressWarnings("unchecked")
		Set<String> keys = (Set<String>) WeakMapping.get(layout, KEYS_KEY);
		if (keys == null) {
			return Collections.emptySet();
		}
		return keys;
	}

}
