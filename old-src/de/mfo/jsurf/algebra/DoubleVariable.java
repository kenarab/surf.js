/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.mfo.jsurf.algebra;

/**
 *
 * @author Christian Stussak <christian at knorf.de>
 */
public class DoubleVariable implements DoubleOperation
{
    public String name;

    public DoubleVariable()
    {
    }

    public String getName()
    {
	return name;
    }

    public void setName(String name)
    {
	this.name= name;
    }

    public DoubleVariable(String name)
    {
	this.name= name;
    }

    public <RETURN_TYPE, PARAM_TYPE> RETURN_TYPE accept(Visitor<RETURN_TYPE, PARAM_TYPE> visitor, PARAM_TYPE arg)
    {
	return visitor.visit(this, arg);
    }
}
