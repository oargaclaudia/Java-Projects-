package model;

import java.util.Objects;

public abstract class Task {
    private String taskID; //atributul taskID
    private String descriere; //atributul descriere
    public Task(String taskID, String descriere) //constructor cu parametrii
    {this.taskID=taskID;
        this.descriere=descriere;
    }


    public String getTaskID() {       //getter pt id-ul taskului
        return taskID;
    }

    public void setTaskID(String taskID) {     //setter pt id-ul taskului

        this.taskID = taskID;
    }

    public String getDescriere() {       //getter pt descriere

        return descriere;
    }

    public void setDescriere(String descriere) {    //setter pt descriere
        this.descriere = descriere;
    }

    public abstract void execute(); //   //metoda abstracta execute
    //nu exista o implementare a metodei
    //o vom implementa ulterior in alta clasa derivata

    @Override   //suprascriem metoda tostring
    //in acest fel se reprezinta in varianta string obiectul
    public String toString()
    {return taskID+" "+descriere;
    }

    @Override  //suprascriem metoda equals
    //returnează egalitatea referințelor;
    //trebuie să fie suprascrisă pentru a realiza egalitatea de conţinut în
    //subclase
    public boolean equals(Object obiect)
    {if (this==obiect) //daca au aceeasi adresa
        return true;
    if (!(obiect instanceof Task)) //verifica daca obiectul este din clasa Task
        return false;    //daca nu este din clasa Task va returna False
    Task task=(Task)obiect;
    return Objects.equals(getTaskID(), task.getTaskID()) && Objects.equals(getDescriere(), task.getDescriere());
    }

    @Override  //suprascriem metoda hashCode
    //returnează valoarea codului de dispersie pentru
    //obiect; valorile sunt diferite pentru obiecte diferite
    public int hashCode() //
    {return Objects.hash(getTaskID(), getDescriere());
    }

}
