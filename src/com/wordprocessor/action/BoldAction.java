package com.wordprocessor.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.text.BadLocationException;

import com.wordprocessor.core.WordProcessor;
import com.wordprocessor.util.DocUtils;

public class BoldAction extends AbstractAction {
	
	private static final long serialVersionUID = 4962144025955340428L;
	private WordProcessor wordProcessor = null;
	
	public BoldAction(WordProcessor wp, Icon i) {
		super(null, i);
		this.wordProcessor = wp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		boolean selection = false;
		
		DocUtils.buttonDoClick(e);
		
		wordProcessor.area1.requestFocus();
		String text = wordProcessor.area1.getSelectedText();
		int start = 0, length = 0;
		if (text != null) {
			selection = true;
			start = wordProcessor.area1.getSelectionStart();
			length = text.length();
		}
		
		if (wordProcessor.bold.isSelected()) {
			try {
				if (selection) {
					wordProcessor.doc.remove(start, length);
					wordProcessor.doc.insertString(start, text, wordProcessor.doc.getStyle("bold"));
				}
			}
			catch (BadLocationException ble) {
				ble.printStackTrace();
			}
		}
		else {
			try {
				if (selection) {
					wordProcessor.doc.remove(start, length);
					wordProcessor.doc.insertString(start, text, wordProcessor.doc.getStyle("regular"));
				}
			}
			catch (BadLocationException ble) {
				ble.printStackTrace();
			}
		}
	}
	
}
