package org.jlab.cnuphys.histogram;

import java.util.ArrayList;

public class ParameterSet {

ArrayList<Parameter> sParameters;
    
    public ParameterSet() {
        sParameters = new ArrayList<Parameter>();
    }
    
    public void add(Parameter par) {
        sParameters.add(par);
    }
    
    public void add(String name, double value) {
        sParameters.add(new Parameter(name,value));
    }
    
    public void add(String name, double value, double min, double max) {
        sParameters.add(new Parameter(name,value,min,max));
    }
    
    public int count() {
        return sParameters.size();
    }
    
    public void create(int n) {
        Integer num = 0;
        for(int i = 0; i < n; i++) {
            String name = "p" + num.toString();
            num++;
            add(name,0.0);
        }
    }
    
    public Parameter get(int index) {
        return sParameters.get(index);
    }
    
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("Parameter SET printout\n");
        str.append("**************************\n");
        for(int i = 0; i < sParameters.size(); i++) {
            str.append(sParameters.get(i).toString()+"\n");
        }
        return str.toString();
    }
    
    public void randomize() {
        for(int i = 0; i < sParameters.size(); i++) {
            sParameters.get(i).setRandom();
        }
    }
    public double[] getRandom() {
        double[] values = new double[sParameters.size()];
        for(int i = 0; i < sParameters.size(); i++) {
            values[i] = sParameters.get(i).getRandom();
        }
        return values;
    }
}
