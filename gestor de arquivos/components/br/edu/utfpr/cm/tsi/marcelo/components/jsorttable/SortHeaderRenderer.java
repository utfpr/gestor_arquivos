/*
 =====================================================================
 
 SortHeaderRenderer.java
 
 Created by Claude Duguay
 Copyright (c) 2002
 
 
 Modified by Renato F. V. da Costa
 2005
 
 =====================================================================
 */

package br.edu.utfpr.cm.tsi.marcelo.components.jsorttable;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;


public class SortHeaderRenderer
	extends DefaultTableCellRenderer
{

	//Added by jSMS
	private static final long serialVersionUID = 3258132457596466995L;

	public static Icon ASCENDING = new SortArrowIcon(SortArrowIcon.ASCENDING);
	public static Icon DECENDING = new SortArrowIcon(SortArrowIcon.DECENDING);
	public static Icon NONSORTED = new SortArrowIcon(SortArrowIcon.NONE);


	public SortHeaderRenderer()
	{
		setHorizontalTextPosition(LEFT);
		setHorizontalAlignment(CENTER);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col)
	{
		int index = -1;
		boolean ascending = true;

		if (table instanceof JSortTable)
		{
			JSortTable sortTable = (JSortTable) table;
			index = sortTable.getSortedColumnIndex();
			ascending = sortTable.isSortedColumnAscending();
		}

		if (table != null)
		{
			JTableHeader header = table.getTableHeader();
			if (header != null)
			{
				setForeground( header.getForeground() );
				setBackground( header.getBackground() );
				setFont( header.getFont() );
			}
		}


		Icon icon = ascending ? ASCENDING : DECENDING;
		setIcon( col == index ? icon : NONSORTED );
		setText( (value == null) ? "" : value.toString() );
		setBorder( UIManager.getBorder("TableHeader.cellBorder") );

		return this;
	}

}
