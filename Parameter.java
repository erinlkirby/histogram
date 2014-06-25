package org.jlab.cnuphys.histogram;

/**
 * Defines methods for creating and modifying a parameter object
 * with a value, name, error, and min and max values.
 * 
 * @author Erin Kirby
 * @version 061914
 */
public class Parameter {

    String pName;
    double pValue;
    double pMin;
    double pMax;
    double pError;
    
    /**
     * Creates a default Parameter object with the name "p0," a value of zero,
     *  a min value of -1.0e-10 and a max value of 1.0e-10, and no error value.
     */
    public Parameter() {
    	pName  = "p0";
        pValue = 0.;
        pMin = -1.0e-10;
        pMax =  1.0e-10;
        pError = 0.0;
    }
    
    /**
     * Creates a Parameter object with the specified value and name.
     * Initializes the min and max values to -1.0e-10 and 1.0e-10, respectively.
     * It also initializes the error value to 0.0.
     * 
     * @param name		The desired name of the Parameter object
     * @param value		The desired value of the Parameter object
     */
    public Parameter(String name, double value) {
        pName  = name;
        pValue = value;
        pMin   = -1e-10;
        pMax   = 1e10;
        pError = 0.0;
    }
    
    /**
     * Initializes a Parameter object with the specified parameters. 
     *
     * @param name		The desired name of the Parameter
     * @param value		The desired value of the Parameter
     * @param min		The min value of the Parameter
     * @param max		The max value of the Parameter
     */
    public Parameter(String name, double value, double min, double max) {
    	pName  = name;
        pValue = value;
        this.setLimits(min, max);
        pError = 0.0;
    }
    
    /**
     * Sets the error value of the parameter.
     * 
     * @param err		The desired error value.
     */
    public void setError(double err) {
    	pError = err;
    }
    
    /**
     * Sets the name of the parameter
     * 
     * @param name		The desired name of the parameter
     */
    public void setName(String name) {
    	pName = name;
    }
    
    /**
     * Sets the min and max values of the parameter
     * 
     * @param min		The desired min value of the parameter
     * @param max		The desired max value of the parameter
     */
    public final void setLimits(double min, double max) {
    	if (min <= max) {
    		pMin = min;
    		pMax = max;
    	}
    	
    	else {
    		pMin = max;
    		pMax = min;
    	}
    }
    
    /**
     * Scales the min and max limits by a specified factor
     * @param factor		The factor to scale the limits by
     */
    public void multLimits(double factor) {
    	double range = Math.abs(pMin - pMax);
    	double median = pMin + Math.abs(pMax-pMin)/2.;
        pMin = median - range*factor;
        pMax = median + range*factor;
    }
    
    /**
     * Sets the value of the parameter
     * 
     * @param val		The desired value of the parameter
     */
    public void setValue(double val) {
    	pValue = val;
    }
    
    /**
     * 
     * @return		the value of the parameter
     */
    public double value() {
    	return pValue;
    }
    
    /**
     * 
     * @return		the name of the parameter
     */
    public String name() {
    	return pName;
    }
    
    /**
     * 
     * @return		the minimum value of the parameter
     */
    public double min() {
    	return pMin;
    }
    
    /**
     * 
     * @return		the maximum value of the parameter
     */
    public double max() {
    	return pMax;
    }
    
    /**
     * 
     * @return		the error value of the parameter
     */
    public double error() {
    	return pError;
    }
    
    /**
     * Sets the value of the parameter to a random value in the range
     */
    public void setRandom()
    {
        pValue = pMin + Math.random()*Math.abs(pMax-pMin);
    }
    
    /**
     * 
     * @return		a random value in the range
     */
    public double getRandom()
    {
        return pMin + Math.random()*Math.abs(pMax-pMin);
    }

    /**
     * Creates a string representation of the parameter.
     */
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append(String.format("%18s : %18e %18e %18e %18e", this.name(),
                this.value(),this.error(),this.min(),this.max()));
        return str.toString();
    }
}
