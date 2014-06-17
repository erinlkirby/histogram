package org.jlab.cnuphys.histogram;

/**
 * 
 * @author Erin Kirby
 * @version 061714
 */
public interface IFunction {

    int     getNpars();
    void    setLimits(double min, double max);
    void    setLimits(double min, double max, int axis);
    void    print();
    double  min();
    double  max();
    double  min(int axis);
    double  max(int axis);
    
    void    init(int npars);
    void    setParameter(int par, double value);
    void    setParameter(int par, double value, double min, double max);
    void    setParLimits(int par, double min, double max);
    void    setParameters(double[] pars);
    double  getParameter(int par);
    double  getParameterMin(int par);
    double  getParameterMax(int par);
    double  evaluate(double x);
    double  evaluate(double x, double y);
}
