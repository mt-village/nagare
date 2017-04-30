/**
 * @(#)ExFunc.java		2017/04/28
 *
 * Copyright (c) 2017 BrainPad, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * BrainPad, Inc. ("Confidential Information").
 * You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement
 * you entered into with BrainPad, Inc.
 */
package com.nagare.ex;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author kenichiro.murayama
 *
 */
public interface ExFunc<E extends Exception, A> {

    Optional<A> handler(Consumer<E> s);
}
