/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.biomed.mkwidzinska.bloodlab;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BloodResults implements Serializable {

    @Id
    private String pesel;
    private String firstName;
    @OneToMany(mappedBy = "bloodResults")
    private List<BloodParameter> bloodparameter;

    public BloodResults() {
    }

    public BloodResults(String pesel, String firstName, List<BloodParameter> bloodparameter) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.bloodparameter = (bloodparameter != null) ? new LinkedList<BloodParameter>(bloodparameter) : null;
    }

   

    
    


}
