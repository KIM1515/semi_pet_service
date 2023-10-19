/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.person.model;

import java.sql.SQLException;

public class PersonService {
    private static PersonDAO dao;
    private static PersonDTO dto;
    private static String nickname;
    private static String id;
    private static int personno;

    public static String getNickname() {
        return nickname;
    }

    public static void setNickname(String nickname) {
        PersonService.nickname = nickname;
    }

    public static String getId() { 
        return id;
    }

    public static void setId(String id) {
        PersonService.id = id;
    }
    
    public static int getPersonno() {
        return personno;
    }

    public static void setPersonno(int personno) {
        PersonService.personno = personno;
    }
    
    public static PersonDTO setDto(String id) throws SQLException{
        dto = dao.selectById(PersonService.id);
        System.out.println("메서드에서 만들어진 dto : " + dto);
        return dto;
    }
    
}
