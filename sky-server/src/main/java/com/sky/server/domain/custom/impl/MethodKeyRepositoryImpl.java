package com.sky.server.domain.custom.impl;

import com.mysema.query.jpa.impl.JPAQuery;
import com.sky.commons.domain.ClassKey;
import com.sky.commons.domain.MethodKey;
import com.sky.commons.domain.QClassKey;
import com.sky.commons.domain.QMethodKey;
import com.sky.server.domain.custom.MethodKeyRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

/**
 * Created by jcooky on 2014. 7. 9..
 */
public class MethodKeyRepositoryImpl implements MethodKeyRepositoryCustom {
  @Autowired
  private EntityManager em;

  @Override
  public MethodKey findBySignatureAndNameAndClassKey(String signature, String name, ClassKey classKey) {

    QMethodKey _methodKey = new QMethodKey("methodKey");
    QClassKey _classKey = new QClassKey("classKey");

    JPAQuery query = new JPAQuery(em);
    return query.from(_methodKey, _classKey)
        .where(_methodKey.signature.eq(signature), _methodKey.name.eq(name), _methodKey.classKey.eq(classKey))
        .uniqueResult(_methodKey);
  }
}
