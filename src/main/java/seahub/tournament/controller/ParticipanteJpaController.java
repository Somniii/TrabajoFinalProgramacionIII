/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.tournament.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import seahub.tournamentproyect.logic.Torneo;
import seahub.tournamentproyect.logic.Administrador;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import seahub.tournament.controller.exceptions.IllegalOrphanException;
import seahub.tournament.controller.exceptions.NonexistentEntityException;
import seahub.tournament.controller.exceptions.PreexistingEntityException;
import seahub.tournamentproyect.logic.Participante;

/**
 *
 * @author Alumno
 */
public class ParticipanteJpaController implements Serializable {

    public ParticipanteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ParticipanteJpaController(){
        emf = Persistence.createEntityManagerFactory("torneoJPAPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Participante participante) throws PreexistingEntityException, Exception {
        if (participante.getAdministradorCollection() == null) {
            participante.setAdministradorCollection(new ArrayList<Administrador>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Torneo idTorneo = participante.getIdTorneo();
            if (idTorneo != null) {
                idTorneo = em.getReference(idTorneo.getClass(), idTorneo.getIdTorneo());
                participante.setIdTorneo(idTorneo);
            }
            Collection<Administrador> attachedAdministradorCollection = new ArrayList<Administrador>();
            for (Administrador administradorCollectionAdministradorToAttach : participante.getAdministradorCollection()) {
                administradorCollectionAdministradorToAttach = em.getReference(administradorCollectionAdministradorToAttach.getClass(), administradorCollectionAdministradorToAttach.getIdAdministrador());
                attachedAdministradorCollection.add(administradorCollectionAdministradorToAttach);
            }
            participante.setAdministradorCollection(attachedAdministradorCollection);
            em.persist(participante);
            if (idTorneo != null) {
                idTorneo.getParticipanteCollection().add(participante);
                idTorneo = em.merge(idTorneo);
            }
            for (Administrador administradorCollectionAdministrador : participante.getAdministradorCollection()) {
                Participante oldIdParticipanteOfAdministradorCollectionAdministrador = administradorCollectionAdministrador.getIdParticipante();
                administradorCollectionAdministrador.setIdParticipante(participante);
                administradorCollectionAdministrador = em.merge(administradorCollectionAdministrador);
                if (oldIdParticipanteOfAdministradorCollectionAdministrador != null) {
                    oldIdParticipanteOfAdministradorCollectionAdministrador.getAdministradorCollection().remove(administradorCollectionAdministrador);
                    oldIdParticipanteOfAdministradorCollectionAdministrador = em.merge(oldIdParticipanteOfAdministradorCollectionAdministrador);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findParticipante(participante.getIdParticipante()) != null) {
                throw new PreexistingEntityException("Participante " + participante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Participante participante) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Participante persistentParticipante = em.find(Participante.class, participante.getIdParticipante());
            Torneo idTorneoOld = persistentParticipante.getIdTorneo();
            Torneo idTorneoNew = participante.getIdTorneo();
            Collection<Administrador> administradorCollectionOld = persistentParticipante.getAdministradorCollection();
            Collection<Administrador> administradorCollectionNew = participante.getAdministradorCollection();
            List<String> illegalOrphanMessages = null;
            for (Administrador administradorCollectionOldAdministrador : administradorCollectionOld) {
                if (!administradorCollectionNew.contains(administradorCollectionOldAdministrador)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Administrador " + administradorCollectionOldAdministrador + " since its idParticipante field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idTorneoNew != null) {
                idTorneoNew = em.getReference(idTorneoNew.getClass(), idTorneoNew.getIdTorneo());
                participante.setIdTorneo(idTorneoNew);
            }
            Collection<Administrador> attachedAdministradorCollectionNew = new ArrayList<Administrador>();
            for (Administrador administradorCollectionNewAdministradorToAttach : administradorCollectionNew) {
                administradorCollectionNewAdministradorToAttach = em.getReference(administradorCollectionNewAdministradorToAttach.getClass(), administradorCollectionNewAdministradorToAttach.getIdAdministrador());
                attachedAdministradorCollectionNew.add(administradorCollectionNewAdministradorToAttach);
            }
            administradorCollectionNew = attachedAdministradorCollectionNew;
            participante.setAdministradorCollection(administradorCollectionNew);
            participante = em.merge(participante);
            if (idTorneoOld != null && !idTorneoOld.equals(idTorneoNew)) {
                idTorneoOld.getParticipanteCollection().remove(participante);
                idTorneoOld = em.merge(idTorneoOld);
            }
            if (idTorneoNew != null && !idTorneoNew.equals(idTorneoOld)) {
                idTorneoNew.getParticipanteCollection().add(participante);
                idTorneoNew = em.merge(idTorneoNew);
            }
            for (Administrador administradorCollectionNewAdministrador : administradorCollectionNew) {
                if (!administradorCollectionOld.contains(administradorCollectionNewAdministrador)) {
                    Participante oldIdParticipanteOfAdministradorCollectionNewAdministrador = administradorCollectionNewAdministrador.getIdParticipante();
                    administradorCollectionNewAdministrador.setIdParticipante(participante);
                    administradorCollectionNewAdministrador = em.merge(administradorCollectionNewAdministrador);
                    if (oldIdParticipanteOfAdministradorCollectionNewAdministrador != null && !oldIdParticipanteOfAdministradorCollectionNewAdministrador.equals(participante)) {
                        oldIdParticipanteOfAdministradorCollectionNewAdministrador.getAdministradorCollection().remove(administradorCollectionNewAdministrador);
                        oldIdParticipanteOfAdministradorCollectionNewAdministrador = em.merge(oldIdParticipanteOfAdministradorCollectionNewAdministrador);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = participante.getIdParticipante();
                if (findParticipante(id) == null) {
                    throw new NonexistentEntityException("The participante with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Participante participante;
            try {
                participante = em.getReference(Participante.class, id);
                participante.getIdParticipante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The participante with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Administrador> administradorCollectionOrphanCheck = participante.getAdministradorCollection();
            for (Administrador administradorCollectionOrphanCheckAdministrador : administradorCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Participante (" + participante + ") cannot be destroyed since the Administrador " + administradorCollectionOrphanCheckAdministrador + " in its administradorCollection field has a non-nullable idParticipante field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Torneo idTorneo = participante.getIdTorneo();
            if (idTorneo != null) {
                idTorneo.getParticipanteCollection().remove(participante);
                idTorneo = em.merge(idTorneo);
            }
            em.remove(participante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Participante> findParticipanteEntities() {
        return findParticipanteEntities(true, -1, -1);
    }

    public List<Participante> findParticipanteEntities(int maxResults, int firstResult) {
        return findParticipanteEntities(false, maxResults, firstResult);
    }

    private List<Participante> findParticipanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Participante.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Participante findParticipante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Participante.class, id);
        } finally {
            em.close();
        }
    }

    public int getParticipanteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Participante> rt = cq.from(Participante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
