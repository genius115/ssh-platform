package org.ssh.comm.utils;

import java.io.Serializable;  

import org.hibernate.Session;  
  
public abstract interface HibernateHandler extends Serializable {  
    public abstract Object doInHibernate(Session paramSession);  
}  