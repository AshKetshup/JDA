/*
 * Copyright 2015-2019 Austin Keener, Michael Ritter, Florian Spieß, and the JDA contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dv8tion.jda.api.events.guild.invite;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.guild.GenericGuildEvent;

import javax.annotation.Nonnull;

public class GenericGuildInviteEvent extends GenericGuildEvent
{
    private final String code;
    private final GuildChannel channel;

    public GenericGuildInviteEvent(@Nonnull JDA api, long responseNumber, @Nonnull String code, @Nonnull GuildChannel channel)
    {
        super(api, responseNumber, channel.getGuild());
        this.code = code;
        this.channel = channel;
    }

    @Nonnull
    public String getCode()
    {
        return code;
    }

    @Nonnull
    public GuildChannel getChannel()
    {
        return channel;
    }

    @Nonnull
    public ChannelType getChannelType()
    {
        return channel.getType();
    }

    @Nonnull
    public TextChannel getTextChannel()
    {
        if (getChannelType() != ChannelType.TEXT)
            throw new IllegalStateException("The channel is not of type TEXT");
        return (TextChannel) getChannel();
    }

    @Nonnull
    public VoiceChannel getVoiceChannel()
    {
        if (getChannelType() != ChannelType.VOICE)
            throw new IllegalStateException("The channel is not of type VOICE");
        return (VoiceChannel) getChannel();
    }

    @Nonnull
    public StoreChannel getStoreChannel()
    {
        if (getChannelType() != ChannelType.STORE)
            throw new IllegalStateException("The channel is not of type STORE");
        return (StoreChannel) getChannel();
    }

    @Nonnull
    public Category getCategory()
    {
        if (getChannelType() != ChannelType.CATEGORY)
            throw new IllegalStateException("The channel is not of type CATEGORY");
        return (Category) getChannel();
    }
}
