package com.enit.test;

import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.enit.model.Compte;
import com.enit.services.IBanqueRemote;



public class TestEjbDistant {

	public static void main(String[] args) throws NamingException{
		// TODO Auto-generated method stub

		String appName=""; 
		String moduleName="EJBbanqueInfoA1"; 
		String distinctName="banqueInfo1"; 
		String viewClassName=IBanqueRemote.class.getName();
	    System.out.println(viewClassName); 
		// JNDI start

		Context ctx=new InitialContext();
    String ejbRemoteJNDIName="ejb:"+appName+"/"+moduleName+"/"+distinctName+"!"+viewClassName; 
    System.out.println(ejbRemoteJNDIName); 
		
	IBanqueRemote stub=(IBanqueRemote) ctx.lookup(ejbRemoteJNDIName);
   System.out.println("stub= "+stub); 
   ctx.close();
   
   //System.out.println("Versement d'un montant"); 
	//stub.verser(2L, 22000); 
/*	Compte c1 = new Compte(1L, 500, new Date());
     Compte c2 = new Compte(2L, 700, new Date());
     Compte c3 = new Compte(3L, 800, new Date());
     Compte c4 = new Compte(4L, 900, new Date());
  stub.addCompte(c1);
  stub.addCompte(c2);
  stub.addCompte(c3);
  stub.addCompte(c4);*/
   stub.verser(2L, 22000); 
	System.out.println("Affichage de tous les comptes"); 
	List<Compte> cptes=stub.consulterComptes(); 
	for(Compte cp:cptes) System.out.println(cp); 
/*	System.out.println("Versement d'un montant"); 
	stub.verser(2L, 22000); 
	System.out.println("Consultation du compte 2");
	Compte cp=stub.consulterCompte(2L); 
	System.out.println(cp);
	stub.retirer(1L, 300); 
	System.out.println("Consultation du compte 1");
	cp=stub.consulterCompte(1L); System.out.println(cp);
	*/
		
	}

}
