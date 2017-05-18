/*
 * Copyright (C) 2013 Evgeniy Egorov
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * FServiceLangList.java
 *
 * Created on May 17, 2013, 12:42:29 PM
 */
package ru.apertum.qsystem.client.forms;

import java.awt.Frame;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.ResourceMap;
import ru.apertum.qsystem.QSystem;
import ru.apertum.qsystem.common.QLog;
import ru.apertum.qsystem.common.Uses;
import ru.apertum.qsystem.common.exceptions.ClientException;
import ru.apertum.qsystem.server.model.QService;
import ru.apertum.qsystem.server.model.QServiceLang;

/**
 *
 * @author Evgeniy Egorov
 */
public class FServiceLangList extends javax.swing.JDialog {

    /** Creates new form FServiceLangList
     * @param parent
     * @param modal */
    public FServiceLangList(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    private static FServiceLangList serviceLangList;
    private static ResourceMap localeMap = null;

    private static String getLocaleMessage(String key) {
        if (localeMap == null) {
            localeMap = Application.getInstance(QSystem.class).getContext().getResourceMap(FServiceLangList.class);
        }
        return localeMap.getString(key);
    }

    public static void changeServiceLangList(Frame parent, boolean modal, final QService service) {
        QLog.l().logger().info("Редактирование языковых локаций \"" + service.getName() + "\"");
        if (serviceLangList == null) {
            serviceLangList = new FServiceLangList(parent, modal);
        }
        serviceLangList.setTitle(service.getName());
        serviceLangList.service = service;
        serviceLangList.listLng.setModel(new javax.swing.AbstractListModel() {

            @Override
            public int getSize() {
                return service.getLangs().size();
            }

            @Override
            public Object getElementAt(int i) {
                return service.getLangs().toArray()[i];
            }
        });
        Uses.setLocation(serviceLangList);
        serviceLangList.setVisible(true);
    }
    private QService service;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        listLng = new javax.swing.JList();
        ButtonAdd = new javax.swing.JButton();
        ButtonRemove = new javax.swing.JButton();
        ButtonEdit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jPopupMenu1.setName("jPopupMenu1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(ru.apertum.qsystem.QSystem.class).getContext().getActionMap(FServiceLangList.class, this);
        jMenuItem1.setAction(actionMap.get("AddLng")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setAction(actionMap.get("EditLng")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jPopupMenu1.add(jMenuItem2);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jPopupMenu1.add(jSeparator1);

        jMenuItem3.setAction(actionMap.get("RemoveLng")); // NOI18N
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        jPopupMenu1.add(jMenuItem3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        listLng.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listLng.setComponentPopupMenu(jPopupMenu1);
        listLng.setName("listLng"); // NOI18N
        listLng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listLngMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listLng);

        ButtonAdd.setAction(actionMap.get("AddLng")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(ru.apertum.qsystem.QSystem.class).getContext().getResourceMap(FServiceLangList.class);
        ButtonAdd.setText(resourceMap.getString("ButtonAdd.text")); // NOI18N
        ButtonAdd.setName("ButtonAdd"); // NOI18N

        ButtonRemove.setAction(actionMap.get("RemoveLng")); // NOI18N
        ButtonRemove.setText(resourceMap.getString("ButtonRemove.text")); // NOI18N
        ButtonRemove.setName("ButtonRemove"); // NOI18N

        ButtonEdit.setAction(actionMap.get("EditLng")); // NOI18N
        ButtonEdit.setText(resourceMap.getString("ButtonEdit.text")); // NOI18N
        ButtonEdit.setName("ButtonEdit"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonRemove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listLngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listLngMouseClicked
        if (evt.getClickCount() > 1) {
            EditLng();
        }
    }//GEN-LAST:event_listLngMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    @Action
    public void AddLng() {
        edtLng(null);
    }

    @Action
    public void RemoveLng() {
        if (listLng.getSelectedIndex() != -1) {
            final int ind = listLng.getSelectedIndex();
            final boolean remove = service.getLangs().remove(listLng.getSelectedValue());
            if (remove) {
                listLng.setModel(new javax.swing.AbstractListModel() {

                    @Override
                    public int getSize() {
                        return service.getLangs().size();
                    }

                    @Override
                    public Object getElementAt(int i) {
                        return service.getLangs().toArray()[i];
                    }
                });
                if (listLng.getLastVisibleIndex() != -1) {
                    listLng.setSelectedIndex(listLng.getLastVisibleIndex() < ind ? listLng.getLastVisibleIndex() : ind);
                }
            } else {
                throw new ClientException("Bad! Bad!");
            }
        }
    }

    @Action
    public void EditLng() {
        if (listLng.getSelectedIndex() != -1) {
            edtLng((QServiceLang) listLng.getSelectedValue());
        }
    }

    private void edtLng(QServiceLang lng) {
        // Запросим название языка и если оно уникально, то примем
        String lngName = lng == null ? "en_US" : lng.getLang();
        boolean flag = true;
        while (flag) {
            final String old = lngName;
            lngName = (String) JOptionPane.showInputDialog(this, getLocaleMessage("LngList.lng_dialog.caption"), getLocaleMessage("LngList.lng_dialog.caption"), 3, null, null, lngName);
            if (lngName == null) {
                return;
            }
            for (QServiceLang qb : service.getLangs()) {
                if (qb.getLang().equalsIgnoreCase(lngName) && !lngName.equalsIgnoreCase(old)) {
                    JOptionPane.showConfirmDialog(this, getLocaleMessage("LngList.lng_dialog.err0.message"), getLocaleMessage("LngList.lng_dialog.caption"), JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if ("".equals(lngName)) {
                JOptionPane.showConfirmDialog(this, getLocaleMessage("LngList.lng_dialog.err1.message"), getLocaleMessage("LngList.lng_dialog.caption"), JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            } else if (lngName.indexOf('\"') != -1) {
                JOptionPane.showConfirmDialog(this, getLocaleMessage("LngList.lng_dialog.err2.message"), getLocaleMessage("LngList.lng_dialog.caption"), JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            } else if (lngName.length() > 75) {
                JOptionPane.showConfirmDialog(this, getLocaleMessage("LngList.lng_dialog.err3.message"), getLocaleMessage("LngList.lng_dialog.caption"), JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            } else {
                flag = false;
            }
        }
        final QServiceLang item;
        if (lng == null) {
            QLog.l().logger().debug("Добавляем язык \"" + lngName + "\"");
            item = new QServiceLang();
            item.setService(service);
            item.setName(service.getName());
            item.setButtonText(service.getButtonText());
            item.setDescription(service.getDescription());
            item.setInput_caption(service.getInput_caption());
            item.setPreInfoHtml(service.getPreInfoHtml());
            item.setPreInfoPrintText(service.getPreInfoPrintText());
            item.setTicketText(service.getTicketText());
            service.getLangs().add(item);
        } else {
            QLog.l().logger().debug("Редактируем язык \"" + lngName + "\"");
            item = lng;
        }
        item.setLang(lngName);
        listLng.setModel(new javax.swing.AbstractListModel() {

            @Override
            public int getSize() {
                return service.getLangs().size();
            }

            @Override
            public Object getElementAt(int i) {
                return service.getLangs().toArray()[i];
            }
        });
        listLng.setSelectedValue(item, true);
        FServiceChangeDialod.changeServiceLang(null, true, item);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAdd;
    private javax.swing.JButton ButtonEdit;
    private javax.swing.JButton ButtonRemove;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JList listLng;
    // End of variables declaration//GEN-END:variables
}
