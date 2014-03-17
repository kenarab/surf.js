/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.mfo.jsurfer.algebra;

import java.io.Serializable;

/**
 *
 * @author Christian Stussak <christian at knorf.de>
 */
public interface PolynomialOperation extends Serializable
{
    public <RETURN_TYPE, PARAM_TYPE> RETURN_TYPE accept(Visitor<RETURN_TYPE, PARAM_TYPE> visitor, PARAM_TYPE arg);
}
