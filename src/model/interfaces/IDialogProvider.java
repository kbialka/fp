package model.interfaces;

import model.shape.featureEnums.ShapeColor;
import model.shape.featureEnums.ShapeShadingType;
import model.shape.featureEnums.ShapeType;
import model.shape.featureEnums.StartAndEndPointMode;
import view.interfaces.IDialogChoice;

public interface IDialogProvider {

    IDialogChoice<ShapeType> getChooseShapeDialog();

    IDialogChoice<ShapeColor> getChoosePrimaryColorDialog();

    IDialogChoice<ShapeColor> getChooseSecondaryColorDialog();

    IDialogChoice<ShapeShadingType> getChooseShadingTypeDialog();

    IDialogChoice<StartAndEndPointMode> getChooseStartAndEndPointModeDialog();
}
