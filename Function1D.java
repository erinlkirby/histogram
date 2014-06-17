package org.jlab.cnuphys.histogram;

/**
 * @author Erin Kirby
 * @version 061714
 */
public class Function1D implements IFunction {
	
	ParameterSet paramSet;
	double fMin;
	double fMax;
	
	public Function1D() {
		paramSet = new ParameterSet();
	}
	
	public Function1D(int nPars) {
		paramSet = new ParameterSet();
		paramSet.create(nPars);
	}
	
	@Override
	public void setParameter(int par, double value) {
		paramSet.get(par).setValue(value);
	}

	@Override
	public int getNpars() {
		return paramSet.count();
	}

	@Override
	public void setLimits(double min, double max) {
		if (min <= max) {
			fMin = min;
			fMax = max;
		}
		
		else {
			fMin = max;
			fMax = min;
		}
	}

	@Override
	public void setLimits(double min, double max, int axis) {
        if(axis == 0) {
            setLimits(min, max);
        }
        else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
		
	}

	@Override
	public void print() {
		System.out.println(paramSet.toString());
		
	}

	@Override
	public double min() {
		return fMin;
	}

	@Override
	public double max() {
		return fMax;
	}

	@Override
	public double min(int axis) {
		if(axis==0) {
			return min();
		}
		
		else {
	        throw new UnsupportedOperationException("Not supported yet.");
		}
	}

	@Override
	public double max(int axis) {
		if(axis==0) {
			return max();
		}
		
		else {
	        throw new UnsupportedOperationException("Not supported yet.");
		}
	}

	@Override
	public void init(int npars) {
		paramSet.create(npars);
		
	}

	@Override
	public void setParameter(int par, double value, double min, double max) {
        paramSet.get(par).setLimits(min, max);
        paramSet.get(par).setValue(value);
		
	}

	@Override
	public void setParLimits(int par, double min, double max) {
        paramSet.get(par).setLimits(min, max);
		
	}

	@Override
	public void setParameters(double[] pars) {
		if (pars.length != paramSet.count()) {
            System.out.println("-----> error. Mismatch in number of parameters. "
                    + " got " + pars.length + " sould be " + paramSet.count());
		}
		
		else {
			for (int i=0; i < pars.length; i++) {
				this.setParameter(i, pars[i]);
			}
		}
	}

	@Override
	public double getParameter(int par) {
		return paramSet.get(par).value();
	}

	@Override
	public double getParameterMin(int par) {
        return paramSet.get(par).min();
	}

	@Override
	public double getParameterMax(int par) {
        return paramSet.get(par).max();
	}

	@Override
	public double evaluate(double x) {
		return 1.0;
	}

	@Override
	public double evaluate(double x, double y) {
		throw new UnsupportedOperationException("-----> error. This function is 1D. Does not support evaluate(x,y).");
	}
}
