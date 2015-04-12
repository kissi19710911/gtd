package hu.ikiss.gtd.server.business.impl;

import hu.ikiss.gtd.businessinterface.ProjectBusiness;
import hu.ikiss.gtd.dto.ProjectDTO;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectServices implements ProjectBusiness {
  @Autowired
  hu.ikiss.gtd.dao.ProjectDAO projectDao;

  @Override
  public ProjectDTO create(final ProjectDTO dto) throws RemoteException {
    ProjectDTO dtoLocal = new ProjectDTO();
    dtoLocal.setName(dto.getName());
    dtoLocal = this.projectDao.create(dtoLocal);

    dto.setId(dtoLocal.getId());
    dto.setName(dtoLocal.getName());
    return dto;
  }
}
