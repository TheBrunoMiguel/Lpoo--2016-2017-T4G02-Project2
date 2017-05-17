package com.lpoot4g02.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Bruno on 17-05-2017.
 */

public class Animation
{
    private Array<TextureRegion> frames;
    private float maxFrameTime;                 //How long a frame has to stay in view, before switching to the next one
    private float currentFrameTime;             //The time the animation has been in the current frame
    private int frameCount;                     //The number of frames in our animation
    private int frame;                          //The current frame that we're actually in

    public Animation(TextureRegion region, int frameCount, float cycleTime)
    {
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth()/frameCount;
        for(int i = 0; i < frameCount; i++)
        {
            frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }

        this.frameCount = frameCount;
        maxFrameTime = cycleTime/frameCount;
        frame = 0;
    }


    public void update(float dt)
    {
        currentFrameTime += dt;
        if(currentFrameTime > maxFrameTime)
        {
            frame++;
            currentFrameTime = 0;
        }

        if(frame >= frameCount)
        {
            frame = 0;
        }
    }


    public TextureRegion getFrame()
    {
        return frames.get(frame);
    }
}
