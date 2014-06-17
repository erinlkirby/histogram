package org.jlab.cnuphys.histogram;

/**
 * 
 * @author Erin Kirby
 * @version 061714
 */
public class Parameter {

    String pName;
    double pValue;
    double pMin;
    double pMax;
    double pError;
    
    public Parameter() {
    	pName  = "p0";
        pValue = 0.;
        pMin = -1.0e-10;
        pMax =  1.0e-10;
        pError = 0.0;
    }
    
    public Parameter(String name, double value) {
        pName  = name;
        pValue = value;
        pMin   = -1e-10;
        pMax   = 1e10;
        pError = 0.0;
    }
    
    public Parameter(String name, double value, double min, double max) {
    	pName  = name;
        pValue = value;
        this.setLimits(min, max);
        pError = 0.0;
    }
    
    public void setError(double err) {
    	pError = err;
    }
    
    public void setName(String name) {
    	pName = name;
    }
    
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
    
    public void multLimits(double factor) {
    	double range = Math.abs(pMin - pMax);
    	double median = pMin + Math.abs(pMax-pMin)/2.;
        pMin = median - range*factor;
        pMax = median + range*factor;
    }
    
    public void setValue(double val) {
    	pValue = val;
    }
    
    public double value() {
    	return pValue;
    }
    
    public String name() {
    	return pName;
    }
    
    public double min() {
    	return pMin;
    }
    
    public double max() {
    	return pMax;
    }
    
    public double error() {
    	return pError;
    }
    
    public void setRandom()
    {
        pValue = pMin + Math.random()*Math.abs(pMax-pMin);
    }
    
    public double getRandom()
    {
        return pMin + Math.random()*Math.abs(pMax-pMin);
    }

    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append(String.format("%18s : %18e %18e %18e %18e", this.name(),
                this.value(),this.error(),this.min(),this.max()));
        return str.toString();
    }
}
