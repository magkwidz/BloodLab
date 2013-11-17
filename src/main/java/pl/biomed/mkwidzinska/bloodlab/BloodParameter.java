/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.biomed.mkwidzinska.bloodlab;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BloodParameter implements Serializable {

    @Id
    private int id;
    private String name;
    private float value;
    private float maxValue;
    private float minValue;
    @ManyToOne
    @XmlTransient
    private BloodResults bloodResults;

    public BloodParameter() {
        
    }

}
