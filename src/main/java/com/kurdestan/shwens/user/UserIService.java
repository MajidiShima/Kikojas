package com.kurdestan.shwens.user;


public interface UserIService {
 User save(User user);

 User update(User user);

 void delete(Long id);

 User getById(Long id);


}
