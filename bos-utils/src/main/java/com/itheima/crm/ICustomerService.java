
package com.itheima.crm;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ICustomerService", targetNamespace = "http://service.crm.itheima.com/")
@XmlSeeAlso({
 
})
public interface ICustomerService {


    /**
     * 
     * @return
     *     returns java.util.List<com.itheima.crm.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://service.crm.itheima.com/", className = "com.itheima.crm.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://service.crm.itheima.com/", className = "com.itheima.crm.FindAllResponse")
    public List<Customer> findAll();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findDecidedzoneIdByAddress", targetNamespace = "http://service.crm.itheima.com/", className = "com.itheima.crm.FindDecidedzoneIdByAddress")
    @ResponseWrapper(localName = "findDecidedzoneIdByAddressResponse", targetNamespace = "http://service.crm.itheima.com/", className = "com.itheima.crm.FindDecidedzoneIdByAddressResponse")
    public String findDecidedzoneIdByAddress(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "assignCustomersToDecidedzone", targetNamespace = "http://service.crm.itheima.com/", className = "com.itheima.crm.AssignCustomersToDecidedzone")
    @ResponseWrapper(localName = "assignCustomersToDecidedzoneResponse", targetNamespace = "http://service.crm.itheima.com/", className = "com.itheima.crm.AssignCustomersToDecidedzoneResponse")
    public void assignCustomersToDecidedzone(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        List<Integer> arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.itheima.crm.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findCustomerListHasAssociation", targetNamespace = "http://service.crm.itheima.com/", className = "com.itheima.crm.FindCustomerListHasAssociation")
    @ResponseWrapper(localName = "findCustomerListHasAssociationResponse", targetNamespace = "http://service.crm.itheima.com/", className = "com.itheima.crm.FindCustomerListHasAssociationResponse")
    public List<Customer> findCustomerListHasAssociation(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<com.itheima.crm.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findCustomerListNotAssociation", targetNamespace = "http://service.crm.itheima.com/", className = "com.itheima.crm.FindCustomerListNotAssociation")
    @ResponseWrapper(localName = "findCustomerListNotAssociationResponse", targetNamespace = "http://service.crm.itheima.com/", className = "com.itheima.crm.FindCustomerListNotAssociationResponse")
    public List<Customer> findCustomerListNotAssociation();

    /**
     * 
     * @param arg0
     * @return
     *     returns com.itheima.crm.Customer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findCustomerByTelephone", targetNamespace = "http://service.crm.itheima.com/", className = "com.itheima.crm.FindCustomerByTelephone")
    @ResponseWrapper(localName = "findCustomerByTelephoneResponse", targetNamespace = "http://service.crm.itheima.com/", className = "com.itheima.crm.FindCustomerByTelephoneResponse")
    public Customer findCustomerByTelephone(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
