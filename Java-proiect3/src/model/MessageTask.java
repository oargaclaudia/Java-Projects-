package model;

import utils.Constants;

import java.time.LocalDateTime;

public class MessageTask extends Task{
    private String mesaj; //atributul mesaj
    private String from; //atributul from
    private String to; //atributu; to
    private LocalDateTime data; //atributul data
    public MessageTask(String taskID, String descriere, String mesaj, String from, String to, LocalDateTime data)
            //contructor cu parametrii
    {super(taskID, descriere);
        this.mesaj=mesaj;
        this.from=from;
        this.to=to;
        this.data=data;
    }
    @Override
    public void execute() //am definit clasa abstracta in Task
            //deci in clasa derivata o putem folosi
    {System.out.println(toString());}
    @Override
    public String toString() //metoda-to-string
    {return super.toString()+" "+mesaj+" "+from+" "+to+" "+data.format(Constants.DATE_TIME_FORMATTER);
    }

    //getter pt mesaj
    public String getMesaj() {
        return mesaj;
    }

    //getter from
    public String getFrom() {
        return from;
    }

    //getter to
    public String getTo() {
        return to;
    }
    //getter data
    public LocalDateTime getData() {
        return data;
    }

    //setter pt mesaj
    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }
    //detter from
    public void setFrom(String from) {
        this.from = from;
    }
    //setter to
    public void setTo(String to) {
        this.to = to;
    }
    //setter pt data
    public void setData(LocalDateTime data) {
        this.data = data;
    }
}

